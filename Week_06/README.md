#### 动态规划

英文全称Dynamic Programming ，简称DP。本质其实就是动态递推。

DP处理问题的关键点：

1.定义子问题

2.定义好状态空间

3.动态规划方程


动态规划小结：

1. 打破自己的思维惯性，形成机器思维

2. 理解复杂逻辑的关键

3. 也是职业进阶的要点要领


#### 算法题

##### [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)

1.定义子问题:f(i,j)=f(i−1,j)+f(i,j−1)

2.定义状态空间:dp[i][j] 

3.DP方程：dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

```java
/**
 * 时间复杂度：O(mn)
 * 空间复杂度：O(mn)
 */
public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
}
```

##### [63. 不同路径Ⅱ](https://leetcode-cn.com/problems/unique-paths-ii/)

```java
/**
 * 时间复杂度：O(mn)
 * 空间复杂度：O(m)
 */
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] dp = new int[m];
        if (obstacleGrid[0][0] == 0) {
            dp[0] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j > 0 && obstacleGrid[i][j-1] == 0) {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[m-1];
}
```

##### [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)

```java
/**
 * 时间复杂度：O(sn),s是金额，n是面额数
 * 空间复杂度：O(s)
 */
public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        int coin_len = coins.length;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coin_len; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
}
```

##### [120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle/)


```java
/**
 * 时间复杂度：O(n^2),n是三角形行数
 * 空间复杂度：O(n)
 */
public int minimumTotal(List<List<Integer>> triangle) {
        int[] minWay = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int  j = 0; j < triangle.get(i).size(); j++) {
                minWay[j] = Math.min(minWay[j] , minWay[j + 1]) + triangle.get(i).get(j);
            }
        }
        return minWay[0];
}
```

##### [1143. 最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)

```java
/**
 * 时间复杂度：O(mn),m、n分别是第一个文本和第二个文本的序列长度
 * 空间复杂度：O(mn)
 */
public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() < 1 ||text2.length() < 1) {
            return 0;
        }
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
}
```

##### [649. Dota2 参议院](https://leetcode-cn.com/problems/dota2-senate/)

```java
/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> R_Que = new LinkedList<Integer>();
        Queue<Integer> D_Que = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                R_Que.offer(i);
            }else {
                D_Que.offer(i);
            }
        }
        while (!R_Que.isEmpty() && !D_Que.isEmpty()) {
            int r = R_Que.poll();
            int d = D_Que.poll();
            if (r < d) {
                R_Que.offer(r + n);
            }else {
                D_Que.offer(d + n);
            }
        }
        return !R_Que.isEmpty() ? "Radiant" : "Dire";
}
```