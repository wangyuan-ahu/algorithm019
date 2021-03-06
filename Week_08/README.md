#### 位运算


1. 为什么需要位运算

	机器里的数字表示方式和存储格式就是二进制
	
	十进制 <—> 二进制 : 如何转换？
	https://zh.wikihow.com/%E4%BB%8E%E5%8D%81%E8%BF%9B%E5%88%B6%E8%BD%AC%E6%8D%A2%E4%B8%BA%E4%BA%8C%E8%BF%9B%E5%88%B6
	
	它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。

2. 位运算符

	左移     <<  
	
	右移     >>   
	
	按位或   ︳
	
	按位与   &
	
	按位取反 ~
	
	按位异或（相同为零不同为一） ^

3. 指定位置的位运算

	1. 将 x 最右边的 n 位清零：x & (~0 << n)
	
	2. 获取 x 的第 n 位值（0 或者 1）： (x >> n) & 1
	
	3. 获取 x 的第 n 位的幂值：x & (1 << n)
	
	4. 仅将第 n 位置为 1：x | (1 << n)
	
	5. 仅将第 n 位置为 0：x & (~ (1 << n))
	
	6. 将 x 最高位至第 n 位（含）清零：x & ((1 << n) - 1)

4. 实战位运算要点

	1. 判断奇偶：x % 2 == 1 —> (x & 1) == 1    x % 2 == 0 —> (x & 1) == 0

	2. x >> 1 —> x / 2. 
	   即： x = x / 2; —> x = x >> 1;
	   mid = (left + right) / 2; —> mid = (left + right) >> 1;
   
	3. X = X & (X-1) 清零最低位的 1

	4. X & -X => 得到最低位的 1

	5. X & ~X => 0
   
   
#### 布隆过滤器


1. HashTable + 拉链存储重复元素

		
2. Bloom Filter vs Hash Table

	一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。

	优点：空间效率和查询时间都远远超过一般的算法；
	
	缺点：有一定的误识别率和删除困难。
	
3. 案例

	1. 比特币网络

	2. 分布式系统（Map-Reduce） — Hadoop、search engine

	3. Redis 缓存

	4. 垃圾邮件、评论等的过滤


#### LRU Cache
	
1.  两个要素： 

	大小 、替换策略

2.  Hash Table + Double LinkedList

3.  O(1) 查询；O(1) 修改、更新

4.  替换策略

	LFU - least frequently used

	LRU - least recently used
	

#### 排序
	
1. 排序算法

	1. 比较类排序：
	
		通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序。
		
	2. 非比较类排序：
	
		不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。
	

2. 初级排序 - O(n^2)

	1. 选择排序（Selection Sort）
	
		每次找最小值，然后放到待排序数组的起始位置。
		
	2. 插入排序（Insertion Sort）
	
		从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
		
	3. 冒泡排序（Bubble Sort）
	
		嵌套循环，每次查看相邻的元素如果逆序，则交换。
		
		
3. 高级排序 - O(N*LogN)

	1. 快速排序（Quick Sort）
	
		数组取标杆 pivot，将小元素放 pivot左边，大元素放右侧，然后依次对右边和右边的子数组继续快排；以达到整个序列有序。
		
		
	2. 归并排序（Merge Sort）— 分治
	
		1. 把长度为n的输入序列分成两个长度为n/2的子序列；
		
		2. 对这两个子序列分别采用归并排序；
		
		3. 将两个排序好的子序列合并成一个最终的排序序列。
		
		4. 归并 和 快排 具有相似性，但步骤顺序相反
		
			归并：先排序左右子数组，然后合并两个有序子数组
			
			快排：先调配出左右子数组，然后对于左右子数组进行排序
			
			
	3. 堆排序（Heap Sort） — 堆插入 O(logN)，取最大/小值 O(1)
	
		1. 数组元素依次建立小顶堆
		
		2. 依次取堆顶元素，并删除

		

	4. 特殊排序 - O(n)
	
		1. 计数排序（Counting Sort）
		
			计数排序要求输入的数据必须是有确定范围的整数。将输入的数据值转化为键存
			储在额外开辟的数组空间中；然后依次把计数大于 1 的填充回原数组
			
		2. 桶排序（Bucket Sort）
		
			桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到
			有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方
			式继续使用桶排序进行排）。
			
		3. 基数排序（Radix Sort）
		
			基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类
			推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按
			高优先级排序。

