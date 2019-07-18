public class Yatzy {
    
    protected int[] dice;
    public Yatzy(int d1, int d2, int d3, int d4, int _5)
    {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
    }

    
    private static int sames(int val, int... dice) {
        int s = 0;
        int i;
        for (i = 0; i < dice.length; i++) 
            if (dice[i] == val)
                s = s + val;
        return s;
        
    }
    private static int[] counts(int... dice) {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die-1]++;
        return counts;
    }
    private static int sum(int... dice) {
        int sum = 0;
        for (int i = 0; i < dice.length; i++) 
            sum += dice[i];
        return sum;
    }
    private static int pairs(int nb, int... dice)
    {
        int[] counts = Yatzy.counts(dice);
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                score += (6-i);
                if (++n == nb)
                    return score * 2; 
            }        
        return 0;
    }
    
    private static int n_of_a_kind(int n, int... dice )
    {
        int[] counts = Yatzy.counts(dice);
        for (int i = 0; i < 6; i++)
            if (counts[i] >= n)
                return (i+1) * n;
        return 0;
    }
    
    private static int straight(int start, int... dice)
    {
        int[] tallies = Yatzy.counts(dice);
        if (tallies[start] == 1 &&
            tallies[start+1] == 1 &&
            tallies[start+2] == 1 &&
            tallies[start+3] == 1 &&
            tallies[start+4] == 1)
            return Yatzy.sum(dice);
        return 0;
    }
        
    public static int chance(int d1, int d2, int d3, int d4, int d5)
    {
        return Yatzy.sum(d1, d2, d3, d4, d5);
    }

    public static int yatzy(int... dice)
    {
        int[] counts = Yatzy.counts(dice);
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }
    
    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return Yatzy.sames(1, d1, d2, d3, d4, d5);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return Yatzy.sames(2, d1, d2, d3, d4, d5);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return Yatzy.sames(3, d1, d2, d3, d4, d5);
    }

    public int fours()
    {
        return Yatzy.sames(4, this.dice);
    }
    
    public int fives()
    {
        return Yatzy.sames(5, this.dice);
    }

    public int sixes()
    {
        return Yatzy.sames(6, this.dice);
    }
    
    public static int score_pair(int d1, int d2, int d3, int d4, int d5)
    {
        return Yatzy.pairs(1, d1, d2, d3, d4, d5);
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5)
    {
        return Yatzy.pairs(2, d1, d2, d3, d4, d5);
    }
    
    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5)
    {
        return n_of_a_kind(4, _1, _2, d3, d4, d5);
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        return n_of_a_kind(3, d1, d2, d3, d4, d5);
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        return Yatzy.straight(0, d1, d2, d3, d4, d5);
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        return Yatzy.straight(1, d1, d2, d3, d4, d5);
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int twoOfAKind = Yatzy.n_of_a_kind(2, d1, d2, d3, d4, d5);
        int threeOfAKind = Yatzy.n_of_a_kind(3, d1, d2, d3, d4, d5);
        if (twoOfAKind > 0 && threeOfAKind > 0)
            return Yatzy.sum(d1, d2, d3, d4, d5);
        return 0;
    }

}
