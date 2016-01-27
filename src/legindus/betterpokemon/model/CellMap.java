package legindus.betterpokemon.model;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class CellMap {
    
    Map<Integer,Map<Integer,Actor>> map;
    
    public CellMap(){
        map = new HashMap<>();
    }
    
    public Actor get(int r, int c){
        Map<Integer,Actor> m = map.get(r);
        return m == null ? null : m.get(c);
    }
    
    public Actor put(int r, int c, Actor a){
        if(!map.containsKey(r)){
            map.put(r,new HashMap<>());
        }
        return map.get(r).put(c,a);
    }
    
    //returns a linkedlist. recommend that you use iterator.
    public List<Actor> actors(){
        List<Actor> l = new LinkedList<>();
        for(Map<Integer,Actor> m:map.values()){
            for(Actor a:m.values()){
                l.add(a);
            }
        }
        
        return l;
    }
    
    
        
    
}
