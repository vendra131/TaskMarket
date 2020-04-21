package com.kodekonveyor.market.integrationtests;

import org.springframework.beans.factory.annotation.Autowired;

import com.kodekonveyor.market.github.GithubGetService;

public class GithubGetServiceTestBase {

  @Autowired
  GithubGetService githubGetService;
}
