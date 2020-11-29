学习笔记


按节点访问的次序不一样分为：1.深度优先搜索 2.广度优先搜索 3.优先级优先搜索（启发式搜索）

DFS 代码 - 递归写法
	visited = set() 
	def dfs(node, visited): 
		if node in visited: # terminator 
		# already visited 
			return 
		 visited.add(node) 
		# process current node here. 
		...
		for next_node in node.children(): 
			if not next_node in visited: 
			dfs(next_node, visited)
			
BFS 代码
	def BFS(graph, start, end): 
		queue = [] 
		queue.append([start]) 
		visited.add(start) 
		while queue: 
			node = queue.pop() 
			visited.add(node) 
			process(node) 
			nodes = generate_related_nodes(node) 
			queue.push(nodes)
			

二分查找的前提：
        1. 目标函数单调性（单调递增或者递减）
        2. 存在上下界（bounded）
        3. 能够通过索引访问（index accessible）

代码模板
        left,right = 0, len(array) - 1
        while left <= right;
            mid = (left + right)/2
            if array[mid] == target;
                # find the target!!
                break or return result
            elif array[mid] < target;
                left = mid + 1
            else:
                right = mid - 1


贪心算法（Greedy）是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。
贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

贪心：当下做局部最优判断（只对当前做最优选择且不会回退）
回溯：能够回退
动态规划：最优判断+回退（保存之前的运算结果，并且在适当的时候进行所谓的回退）

贪心法可以解决一些最优化问题，如：求图中的最小生成树，求哈夫曼编码等。
一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好办法。
由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。			
				


122 买卖股票的最佳时机 Ⅱ（简单）
题目描述：
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:
输入: [7,1,5,3,6,4]
输出: 7

解法思路：
        可以采用贪心法解决：1.可以先定义一个变量表示利益并给初始化为0；
                            2. 依次遍历数组，如果数组的后一个值比前一个值大的话，那我们可以在前一个值购买，然后在后一个值卖出，
                               把后值减前值后加到利益变量里，数组遍历完结束返回利益变量的值即可。							   
							   
代码：
		public int maxProfit(int[] prices) {
			if (prices == null || prices.length < 2) {
				return 0;
			}
			int profit = 0;
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] > prices[i-1]) {
					profit += prices[i] - prices[i - 1];
				}
			}
			return profit;
		}
	


455 分发饼干（简单）
题目描述：
假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j]。
如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

示例：输入： g = [1,2,3], s = [1,1]  输出： 1
      输入： g = [1,2], s = [1,2,3]  输出： 2

解法思路：
       可以采用贪心算法解决：1. 先对两个数组进行一个排序；
                             2. 依次从s数组中取出一个元素，判断其是否大于等于g中数组的最小元素，
                                若大于等于，则满足孩子数量加1，s依次往后取下一个元素与g中的下一个元素进行比较，
                                若不大于，则s依次往后取下一个元素与g中的当前元素继续进行比较，直到s取空或者g取空结束，返回满足孩子数量即可。
	
代码：
		 public int findContentChildren(int[] g, int[] s) {
			int res = 0;
			if (g == null || s == null){
				return res;
			}
			Arrays.sort(g);
			Arrays.sort(s);
			int i = 0;
			int j = 0;
			while (g.length > j && s.length > i) {
				if (s[i] >= g[j]) {
					res++;
					i++;
					j++;
				}else {
					i++;
				}
			}
			return res;
		}
	
	
	
	
860 柠檬水找零（简单）
题目描述：
在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。

注意，一开始你手头没有任何零钱。
如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

示例1： 
输入：[5,5,5,10,20]
输出：true

解法思路：
        因为有三种钞票，分别是5元，10元和20元，而20元是可以由5元和10元来找零
        因此，我们可以对5元和10元的数量通过设置两个变量来表示并且都给初始化为0；
        然后依次遍历数组，如果取出的元素为5，那么不用找零，我们就让表示5的变量数值加1；
        如果取出的元素为10，那么我们需要找零5元，即判断表示5的变量数值是否大于0，若是，则表示5的变量数值减1，而表示10的变量数值加1，若不是，则找不了，返回false;
        如果取出的元素为20，那我们需找零15，即可以先判断5元与10元的变量是否都大于零，若是，则5元与10元的变量数值分别减1，而20元变量数值加1；若不是，则再判断5元的          
		变量数值是否大于2，若是，可以找回3个5元，即表示5元的变量数值减3，若依然不是，则现有零钱找不开20元，返回false。最终若数组成功遍历完，出来后返回ture即可。
	
代码：
		public boolean lemonadeChange(int[] bills) {
				int five = 0, ten = 0;
				for (int bill : bills) {
					if (bill == 5) {
						five++;
					}else if (bill == 10){
						if (five > 0) {
							five--;
							ten++;
						}else {
							return false;
						}
					}else {
						if (five > 0 && ten > 0){
							five--;
							ten--;
						}else if (five > 2) {
							five -= 3;
						}else {
							return false;
						}
					}
				}
				return true;
			}
    