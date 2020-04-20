package com.kodekonveyor.market.github;

import org.springframework.lang.Nullable;

import com.kodekonveyor.annotations.InterfaceClass;

@InterfaceClass
public class FileNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -403037694731462829L;

  public FileNotFoundException(
      final String message, @Nullable final Throwable cause
  ) {
    super(message, cause);
  }
}
