package com.example.g.Presenter;

import com.example.g.Bean;

public interface ICallback {
  void success(Bean bean);
  void failed(String error);
}
