import java.io.*;
import java.util.*;

public class Main {
    static char[][] Up, Down, Front, Back, Left, Right;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            initCube();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                String cmd = st.nextToken();
                char side = cmd.charAt(0);
                char dir = cmd.charAt(1);
                int times = (dir == '+') ? 1 : 3;
                while (times-- > 0) {
                    rotate(side);
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(Up[i][j]);
                }
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }

    static void initCube() {
        Up = fill('w');
        Down = fill('y');
        Front = fill('r');
        Back = fill('o');
        Left = fill('g');
        Right = fill('b');
    }

    static char[][] fill(char c) {
        char[][] arr = new char[3][3];
        for (int y = 0; y < 3; y++)
            for (int x = 0; x < 3; x++)
                arr[y][x] = c;
        return arr;
    }

    static void rotate(char side) {
        switch (side) {
            case 'U':
                rotateU();
                break;
            case 'D':
                rotateD();
                break;
            case 'F':
                rotateF();
                break;
            case 'B':
                rotateB();
                break;
            case 'L':
                rotateL();
                break;
            case 'R':
                rotateR();
                break;
        }
    }

    static void rotateFace(char[][] face) {
        char[][] temp = new char[3][3];
        for (int y = 0; y < 3; y++)
            for (int x = 0; x < 3; x++)
                temp[x][2 - y] = face[y][x];

        for (int y = 0; y < 3; y++)
            for (int x = 0; x < 3; x++)
                face[y][x] = temp[y][x];
    }

    static void rotateU() {
        rotateFace(Up);

        char[] temp = Front[0].clone();
        Front[0] = Right[0].clone();
        Right[0] = Back[0].clone();
        Back[0] = Left[0].clone();
        Left[0] = temp;
    }

    static void rotateD() {
        rotateFace(Down);

        char[] temp = Front[2].clone();
        Front[2] = Left[2].clone();
        Left[2] = Back[2].clone();
        Back[2] = Right[2].clone();
        Right[2] = temp;
    }

    static void rotateF() {
        rotateFace(Front);

        char[] temp = Up[2].clone();

        for (int i = 0; i < 3; i++) {
            Up[2][i] = Left[2 - i][2];
        }

        for (int i = 0; i < 3; i++) {
            Left[i][2] = Down[0][i];
        }

        for (int i = 0; i < 3; i++) {
            Down[0][i] = Right[2 - i][0];
        }

        for (int i = 0; i < 3; i++) {
            Right[i][0] = temp[i];
        }
    }

    static void rotateB() {
        rotateFace(Back);

        char[] temp = Up[0].clone();

        for (int i = 0; i < 3; i++) {
            Up[0][i] = Right[i][2];
        }

        for (int i = 0; i < 3; i++) {
            Right[i][2] = Down[2][2 - i];
        }

        for (int i = 0; i < 3; i++) {
            Down[2][i] = Left[i][0];
        }

        for (int i = 0; i < 3; i++) {
            Left[i][0] = temp[2 - i];
        }
    }

    static void rotateL() {
        rotateFace(Left);

        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = Up[i][0];
        }

        for (int i = 0; i < 3; i++) {
            Up[i][0] = Back[2 - i][2];
        }

        for (int i = 0; i < 3; i++) {
            Back[i][2] = Down[2 - i][0];
        }

        for (int i = 0; i < 3; i++) {
            Down[i][0] = Front[i][0];
        }

        for (int i = 0; i < 3; i++) {
            Front[i][0] = temp[i];
        }
    }

    static void rotateR() {
        rotateFace(Right);

        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = Up[i][2];
        }

        for (int i = 0; i < 3; i++) {
            Up[i][2] = Front[i][2];
        }

        for (int i = 0; i < 3; i++) {
            Front[i][2] = Down[i][2];
        }

        for (int i = 0; i < 3; i++) {
            Down[i][2] = Back[2 - i][0];
        }

        for (int i = 0; i < 3; i++) {
            Back[i][0] = temp[2 - i];
        }
    }
}

