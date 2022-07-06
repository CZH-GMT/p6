package com.example.mvpshujuku.presenter;

import com.example.mvpshujuku.SubBean;

public interface Ipresenter {
  void getFood();

  void getFoodbyDB();

  void insert(SubBean subBean);
}
