import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int coin, int[] cards) {
        Set<Integer> pouch = new HashSet<>();
        Set<Integer> pickCards = new HashSet<>();
        int n = cards.length;
        
        for(int idx = 0; idx < n / 3; idx++){
            pouch.add(cards[idx]);
        }
        
        int idx = n / 3, round = 1;
        while(idx <= n - 2){
            int card1 = cards[idx];
            int card2 = cards[idx + 1];
            idx += 2;

            pickCards.add(card1);
            pickCards.add(card2);
            
            boolean check = false;
            for(int card: new ArrayList<>(pouch)){
                if(pouch.contains(n + 1 - card)){
                    check = true;
                    pouch.remove(card);
                    pouch.remove(n + 1 - card);
                    break;
                }
            }
            
            if(!check && coin > 0){
                for(int card: new ArrayList<>(pouch)){
                    if(pickCards.contains(n + 1 - card)){
                        check = true;
                        pouch.remove(card);
                        pickCards.remove(n + 1 - card);
                        coin--;
                        break;
                    }
                }
            }
                
            if(!check && coin > 1){
                for(int card: new ArrayList<>(pickCards)){
                    if(pickCards.contains(n + 1 - card)){
                        check = true;
                        pickCards.remove(card);
                        pickCards.remove(n + 1 - card);
                        coin -= 2;
                        break;
                    }
                }
            }
            
            if(!check){
                break;
            }
            
            round++;
        }

        return round;
    }
}
