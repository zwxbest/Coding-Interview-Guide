# 为什么是不稳定的

你想想 从左到右比较的时候 你的array可以分成这样四部分

p  |  lower |  higher | unvisited

p指的是pivotal，lower指小于p的部分，unvisited指还未访问到，| 是分割线。

例如：5  |  3 1 2  |  9 7 8 9 | 4 6 3

这时遍历unvisited部分  刚到了4 (array[8])  显然4<5 ，这是4应该从 unvisited 部分去到 lower 部分。 

因此 higher部分第一个元素 9 (array[4]) 和 4互换。

变成了这样：5  |  3 1 2 4 | 7 8 9 9 |  6 3

注意！这时这个9 (array[4]) 被换到了 后面那个9 (array[7])的 后面。

这就不稳定了。

再扩展来说 这不稳定是由于我们在向lower部分插入元素(4)的时候 使用了互换。

而不是直接把 插入位置后面所有元素整体往后移动一位 再填进要插入的数。

其实后一种办法才是我们直觉上所说的插入 但在array上实在是特别慢 O(N)。
