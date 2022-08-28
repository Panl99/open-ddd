package com.only4play.system.template.extension.cola;

import com.alibaba.cola.extension.ExtensionPointI;

public interface HelloServiceExtPt extends ExtensionPointI {

  void say();

  String getName();

}
