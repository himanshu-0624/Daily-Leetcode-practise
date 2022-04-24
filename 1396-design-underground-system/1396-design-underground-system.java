class Pair
{
    String name;
    int t;
    public Pair(String name, int t)
    {
        this.t = t;
        this.name = name;
    }
}
class UndergroundSystem {
     HashMap<String,Double> total;
     HashMap<String,Integer> count;
     HashMap<Integer,Pair> cur;
    public UndergroundSystem() {
        total = new HashMap<>();
         count = new HashMap<>();
         cur = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        cur.put(id,new Pair(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair p = cur.get(id);
        cur.remove(id);
        String st  = p.name+" "+stationName;
        int time = t - p.t;
        count.put(st,count.getOrDefault(st,0)+1);
        total.put(st,total.getOrDefault(st,0.0)+time);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String h = startStation+" "+endStation;
        return total.get(h)/count.get(h);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */