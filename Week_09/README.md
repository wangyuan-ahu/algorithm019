#### 递归、分治、回溯、动态规划复习


1. 递归 - 函数自己调用自己

代码模板：

```java
	public void recur(int level, int param) { 
		// terminator 
		if (level > MAX_LEVEL) { 
			// process result 
			return; 
		} 
		
		// process current logic 
		process(level, param); 
		
		// drill down 
		recur(level: level + 1, newParam); 
		
		// restore current status 
 
	}
```
	

2. 分治：分而治之（Divide & Conquer）

代码模板：

```java
	def divide_conquer(problem, param1, param2, ...): 
		# recursion terminator 
		if problem is None: 
			print_result 
			return 
			
		# prepare data 
		data = prepare_data(problem) 
		subproblems = split_problem(problem, data) 
		
		# conquer subproblems 
		subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
		subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
		subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
		… 
		
		# process and generate the final result 
		result = process_result(subresult1, subresult2, subresult3, …) 
 
		# revert the current level states
```

感触：

	1. 人肉递归低效、很累

	2. 找到最近最简方法，将其拆解成可重复解决的问题

	3. 数学归纳法思维

	本质：寻找重复性 —> 计算机指令集


3. 动态规划（Dynamic Programming）

	1. “Simplifying a complicated problem by breaking it down into simpler sub-problems” (in a recursive manner)

	2. Divide & Conquer + Optimal substructure 
	
	分治 + 最优子结构

	3. 顺推形式： 动态递推
	
	
代码模板：

```java
	function DP(): 
	
		dp = [][] # 二维情况 
		
		for i = 0 .. M { 
			for j = 0 .. N { 
				dp[i][j] = _Function(dp[i’][j’]…) 
			} 
		} 
		
	return dp[M][N];
```

	4. 关键点
	
		动态规划 和 递归或者分治 没有根本上的区别（关键看有无最优的子结构） 
		
		拥有共性：找到重复子问题
		
		差异性：最优子结构、中途可以淘汰次优解

		
4. 不同路径Ⅱ的状态转移方程

		u(i,j) = 0 : f(i,j) = 0;
		
		u(i,j) != 0 : f(i,j) = f(i-1,j)+f(i,j-1);
		
		
5. 高阶的 DP 问题

	复杂度来源:
	
	1. 状态拥有更多维度（二维、三维、或者更多、甚至需要压缩）

	2. 状态方程更加复杂
   
   
#### 字符串基础知识

1. 字符串比较

	Java:
	
	String x = new String(“abb”);
	
	String y = new String(“abb”);
	
	x == y —-> false
	
	x.equals(y) —-> true
	
	x.equalsIgnoreCase(y) —-> true
	

2. 字符串匹配算法

	1. 暴力法
	
	2. Rabin-Karp算法
	
	3. KMP算法
		
