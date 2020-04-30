package com.kodekonveyor.market.github;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kodekonveyor.SpringConfig;
import com.kodekonveyor.annotations.ExcludeFromCodeCoverage;
import com.kodekonveyor.logging.LoggingMarkerConstants;
import com.kodekonveyor.market.proxies.ObjectMapperService;

@Service
@ExcludeFromCodeCoverage("interface to underlying framework")
public class GithubGetService {

  @Autowired
  private Logger loggerService;

  @Autowired
  private ObjectMapperService objectMapperProxy;

  public JsonResultDTO call(final String url) {

    try {
      final HttpClient client = HttpClients.custom().build();
      final HttpUriRequest request = RequestBuilder.get()
          .setUri(url)
          .setHeader(
              HttpHeaders.AUTHORIZATION,
              GithubConstants.TOKEN + SpringConfig.issuetoken
          )
          .build();
      final HttpResponse response = client.execute(request);
      final JsonResultDTO jsonResult = new JsonResultDTO();
      jsonResult.setResult(
          EntityUtils.toString(response.getEntity(), GithubConstants.UTF_8)
      );
      return jsonResult;

    } catch (final IOException exception) {
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR,
          GithubConstants.INTERNAL_ERROR, exception
      );
    }
  }

  public <ValueType> ValueType
      call(final String command, final Class<ValueType> cls) {
    final String uri = GithubConstants.GITHUB_API_URL_BASE + command;
    loggerService.debug(LoggingMarkerConstants.GITHUB, uri);
    URL url;
    try {
      url = new URL(uri);
    } catch (final MalformedURLException exception) {
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR, GithubConstants.INTERNAL_ERROR,
          exception
      );
    }

    final ValueType value;
    try {
      value = objectMapperProxy.call(url, cls);
    } catch (final IOException exception) {
      throw new ResponseStatusException(
          HttpStatus.SERVICE_UNAVAILABLE,
          GithubConstants.CANNOT_CONNECT_TO_GITHUB, exception
      );
    }
    return value;
  }
}
