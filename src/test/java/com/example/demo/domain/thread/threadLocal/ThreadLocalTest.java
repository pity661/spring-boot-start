package com.example.demo.domain.thread.threadLocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-24 15:58
 */
public class ThreadLocalTest {
  // set、 get 方法中用到了ThreadLocalMap 其中 entry 继承 WeakReference，key用Reference存储
  ThreadLocal threadLocal = new ThreadLocal();

  // 包装成同步map
  Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
}
