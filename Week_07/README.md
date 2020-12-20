#### 字典树


1. 字典树的数据结构

	字典树，即 Trie 树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排
	序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。
	
	它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。

2. 字典树的核心思想

	Trie 树的核心思想是空间换时间。
	
	利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

3. 字典树的基本性质

	(1). 结点本身不存完整单词；
	
	(2). 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串；
	
	(3). 每个结点的所有子结点路径代表的字符都不相同。


#### 并查集 Disjoint Set


1. 适用场景：

		组团、配对问题
		
2. 基本操作

	1). makeSet(s)：建立一个新的并查集，其中包含 s 个单元素集合。

	(2). unionSet(x, y)：把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在的集合不相交，如果相交则不合并。

	(3). find(x)：找到元素 x 所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。
	
	
Java 实现代码：

```java
	class UnionFind { 
		private int count = 0; 
		private int[] parent; 
		public UnionFind(int n) { 
			count = n; 
			parent = new int[n]; 
			for (int i = 0; i < n; i++) { 
				parent[i] = i;
			} 			
		} 
		public int find(int p) { 
			while (p != parent[p]) { 
				parent[p] = parent[parent[p]]; 
				p = parent[p]; 
			}
			return p; 
		}
		public void union(int p, int q) { 
			int rootP = find(p); 
			int rootQ = find(q); 
			if (rootP == rootQ) return; 
			parent[rootP] = rootQ; 
			count--;
		} 
	}
```

#### 搜索


1. 朴素搜索

2. 优化方式：不重复（fibonacci）、剪枝（生成括号问题）

3. 搜索方向： 

	DFS: depth first search 深度优先搜索
	
	BFS: breadth first search 广度优先搜索 
	
	双向搜索、启发式搜索
	
	
	
#### 高级树


二叉搜索树（Binary Search Tree）：
也称二叉搜索树、有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的二叉树：

	1. 左子树上所有结点的值均小于它的根结点的值；
	
	2. 右子树上所有结点的值均大于它的根结点的值；
	
	3. 以此类推：左、右子树也分别为二叉查找树。 （这就是重复性！）
	
	中序遍历：升序排列


AVL 树：

	1. 发明者 G. M. Adelson-Velsky和 Evgenii Landis
	
	2. Balance Factor（平衡因子）：是它的左子树的高度减去它的右子树的高度（有时相反）。balance factor = {-1, 0, 1}
	
	3. 通过旋转操作来进行平衡（四种）
	
	4. https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree
	
	不足：结点需要存储额外信息、且调整次数频繁

	
红黑树（Red-black Tree）：
红黑树是一种近似平衡的二叉搜索树（Binary Search Tree），它能够确保任何一个结点的左右子树的高度差小于两倍。
具体来说，红黑树是满足如下条件的二叉搜索树： 

	1. 每个结点要么是红色，要么是黑色
	
	2. 根结点是黑色
	
	3. 每个叶结点（NIL结点，空结点）是黑色的。 
	
	4. 不能有相邻接的两个红色结点 
	
	5. 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点。
	

关键性质：

	从根到叶子的最长的可能路径不多于最短的可能路径的两倍长。


对比
	1. AVL trees provide faster lookups than Red Black Trees because they are more strictly balanced. 
	
	2. Red Black Trees provide faster insertion and removal operations than AVL trees as fewer rotations 
	   are done due to relatively relaxed balancing.
	   
	3. AVL trees store balance factors or heights with each node, thus requires storage for 
	   an integer per node whereas Red Black Tree requires only 1 bit of information per node.
	   
	4. Red Black Trees are used in most of the language libraries likemap, multimap, multisetin C++ 
	   whereas AVL trees are used in databases where faster retrievals are required.