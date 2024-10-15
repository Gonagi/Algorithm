// 히스토그램에서 가장 큰 직사각형
// 6549

/*
#include <algorithm>
#include <iostream>
#include <vector>

int n = 1;

void solve();

int main()
{
  while (1)
  {
    std::cin >> n;
    if (n == 0)
      return 0;
    solve();
  }
  return 0;
}

void solve()
{
  std::vector<long long> height;
  long long max = 0, h;

  for (int idx = 0; idx < n; idx++)
  {
    long long cal = 0;
    int cur_idx;

    std::cin >> h;
    height.push_back(h);

    for (long long cur_h = h; cur_h >= 1; cur_h--)
    {
      for (cur_idx = idx; cur_idx >= 0; cur_idx--)
      {
        if (height[cur_idx] < cur_h)
          break;
      }
      cal = cur_h * (idx - cur_idx);
      max = std::max(max, cal);
    }
  }

  std::cout << max << '\n';
}
*/

/*
// 세그먼트 트리
#include <algorithm>
#include <iostream>
#include <vector>

#define INF 2000000000
std::vector<long long> height, seg_tree;
long long ans;
int n;

int init(std::vector<long long> &seg_tree, int cur_idx, int start_idx, int end_idx);
int query(std::vector<long long> &seg_tree, int cur_idx, int start_idx, int end_idx, int cur_left_idx,
          int cur_right_idx);
void solve(std::vector<long long> &seg_tree, int left_idx, int right_idx);

int main()
{
  long long h;

  while (1)
  {
    std::cin >> n;
    if (n == 0)
      break;

    for (int idx = 0; idx < n; idx++)
    {
      std::cin >> h;
      height.push_back(h);
    }

    std::vector<long long> seg_tree(n * 4);
    init(seg_tree, 1, 0, n - 1);
    solve(seg_tree, 0, n - 1);
    std::cout << ans << '\n';

    height.clear();
    height.shrink_to_fit();
    ans = 0;
  }
  return 0;
}

int init(std::vector<long long> &seg_tree, int cur_idx, int start_idx, int end_idx)
{
  if (start_idx == end_idx)
    return seg_tree[cur_idx] = start_idx;

  int mid_idx = (start_idx + end_idx) / 2;
  int left_idx = init(seg_tree, 2 * cur_idx, start_idx, mid_idx);
  int right_idx = init(seg_tree, 2 * cur_idx + 1, mid_idx + 1, end_idx);

  return seg_tree[cur_idx] = height[left_idx] < height[right_idx] ? left_idx : right_idx;
}

int query(std::vector<long long> &seg_tree, int cur_idx, int start_idx, int end_idx, int cur_left_idx,
          int cur_right_idx)
{
  if (start_idx > cur_right_idx || end_idx < cur_left_idx)
    return INF;
  if (cur_left_idx <= start_idx && end_idx <= cur_right_idx)
    return seg_tree[cur_idx];

  int mid_idx = (start_idx + end_idx) / 2;
  int left_idx = query(seg_tree, 2 * cur_idx, start_idx, mid_idx, cur_left_idx, cur_right_idx);
  int right_idx = query(seg_tree, 2 * cur_idx + 1, mid_idx + 1, end_idx, cur_left_idx, cur_right_idx);

  if (left_idx == INF)
    return right_idx;
  else if (right_idx == INF)
    return left_idx;
  else
    return height[left_idx] < height[right_idx] ? left_idx : right_idx;
}

void solve(std::vector<long long> &seg_tree, int left_idx, int right_idx)
{
  if (left_idx > right_idx)
    return;

  int index = query(seg_tree, 1, 0, n - 1, left_idx, right_idx);
  ans = std::max(ans, height[index] * (right_idx - left_idx + 1));

  solve(seg_tree, left_idx, index - 1);
  solve(seg_tree, index + 1, right_idx);
}
*/

// // 스택
// #include <algorithm>
// #include <iostream>
// #include <stack>
// #include <vector>

// int main()
// {
//   long long h, ans;
//   while (1)
//   {
//     int n;
//     std::cin >> n;
//     if (n == 0)
//       break;

//     std::vector<int> height;
//     for (int idx = 0; idx < n; idx++)
//     {
//       std::cin >> h;
//       height.push_back(h);
//     }
//     height.push_back(-1);

//     long long ans = 0;
//     std::stack<int> stack;

//     for (int idx = 0; idx <= n; idx++)
//     {
//       while (!stack.empty() && height[stack.top()] > height[idx])
//       {
//         int h, w;
//         h = stack.top();
//         stack.pop();

//         if (stack.empty())
//           w = idx;
//         else
//           w = idx - stack.top() - 1;
//         ans = std::max(ans, (long long)height[h] * (long long)(w));
//       }
//       stack.push(idx);
//     }

//     std::cout << ans << '\n';
//   }
//   return 0;
// }