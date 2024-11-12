class Solution {
    int t = 1;
    boolean check = true;
    int curMonster = 0;

    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int heainglCoolTime = bandage[0];
        int healingAmount = bandage[1];
        int healingMore = bandage[2];
        int monsterCount = attacks[attacks.length-1][0];
        int answer = maxHealth;
        
        for(int time = 1; time <= monsterCount; time++){
            int temp = answer;
            answer = attack(attacks, time, answer);
            if(answer <= 0){
                return -1;
            }
            if(temp == answer){
                answer = heal(heainglCoolTime, healingAmount, healingMore, answer);
                if(answer >= maxHealth){
                    answer = maxHealth;
                }
            }
        }
        
        return answer;
    }
    
    private int attack(int[][] attacks, int time, int health){
        if(time == attacks[curMonster][0]){
            health -= attacks[curMonster][1];
            curMonster++;
            t = 1;
        }
        return health;
    }
    
    private int heal(int heainglCoolTime, int healingAmount, int healingMore, int health){
        if(t == heainglCoolTime){
            t = 1;
            return health + healingAmount + healingMore;
        }
        t++;
        return health + healingAmount;
    }
}