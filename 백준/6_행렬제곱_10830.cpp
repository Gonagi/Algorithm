// 행렬 제곱
// 10830

/*
#include <iostream>
#include <vector>

int main()
{
  std::vector<std::vector<int>> vec;
  std::vector<int> vec_x;
  int N, num;
  long long B;

  std::cin >> N >> B;
  std::vector<std::vector<int>> result(N, std::vector<int>(N, 0));

  for (int y = 0; y < N; y++)
  {
    for (int x = 0; x < N; x++)
    {
      std::cin >> num;
      vec_x.push_back(num);

      if (y == x)
        result[y][x] = 1;
    }
    vec.push_back(vec_x);

    vec_x.clear();
    vec_x.shrink_to_fit();
  }

  if (B != 1)
  {
    while (B > 0)
    {
      if (B & 1)
      {
        std::vector<std::vector<int>> temp(N, std::vector<int>(N, 0));

        for (int k = 0; k < N; k++)
        {
          for (int y = 0; y < N; y++)
          {
            int cal = result[y][k];

            for (int x = 0; x < N; x++)
              temp[y][x] += (cal * vec[k][x]) % 1000;
          }
        }
        result = temp;
      }

      std::vector<std::vector<int>> temp(N, std::vector<int>(N, 0));
      for (int k = 0; k < N; k++)
      {
        for (int y = 0; y < N; y++)
        {
          int cal = vec[y][k];
          for (int x = 0; x < N; x++)
            temp[y][x] += (cal * vec[k][x]) % 1000;
        }
      }
      vec = temp;

      B = B >> 1;
    }
  }
  else
    result = vec;

  for (int y = 0; y < N; y++)
  {
    for (int x = 0; x < N; x++)
    {
      std::cout << result[y][x] % 1000 << ' ';
    }
    std::cout << '\n';
  }

  return 0;
}
*/