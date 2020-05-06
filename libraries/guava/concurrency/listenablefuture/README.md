## ListenableFuture

ListenableFuture 是继承了 JDK `Feature` 接口的，官方强烈推荐在使用多线程的时候，用 `ListenableFuture` 替换 `Future`

JDK 自带的 `Feature` 可以在线程结束后返回结果，而 `ListenableFuture` 可以注册一个 Callback，以便在线程结束后调用 callback。

`ListenableFuture` 基础的用法是 `addListener(Runnable, Executor)`，可以让指定的 `Runnable` 在指定的 `Executor` 中运行

### 回调

大多数人用ListenableFuture 还是为了用回调，基本的用法是 `Futures.addCallback(ListenableFuture<V>, FutureCallback<V>, Executor)`。
FutureCallback<V> 需要实现两个方法 :

  - onSuccess(V)
  - onFailure(Throwable)

方法都很简单，无需过多解释。
