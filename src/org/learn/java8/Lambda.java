import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class Lambda {

	public static void main(String[] args) {
		Item shirt = new Item(1, 1000.00, "Allen Solley");
		Item pant = new Item(1, 500.00, "Levis");
		Item shoe = new Item(1, 3000.00, "Nike");
		List<Item> items = new ArrayList<Item>();
		items.add(shoe);
		items.add(pant);
		items.add(shirt);
		items.sort((Item i1,Item i2)->i1.getRate().compareTo(i2.getRate()));
		items.sort((i1,i2)->i1.getRate().compareTo(i2.getRate()));
		List<Item> costly = filter(items,(Item i)->i.getRate()>500);
		//List<Item> nully = filter(items,null);
		operate(costly,(Item i)->System.out.println(i));
		operate(costly,(Item i)->i.setRate(i.getRate()+200));
		operate(costly,(Item i)->System.out.println(i));
		System.out.println(items);
		
		
		
	}

	public static<T> List<T> filter (List<T> list , Predicate<T> p){
		List<T> results = new ArrayList<T>();
		for(T s: list){
			if(p.test(s)){
				results.add(s);
			}
		}
		return results;
	}
	
	public static <T> void operate(List<T> list, Consumer<T> c){
		for(T t :list){
			c.accept(t);
		}
	}
	
	public static <T,R> List<R> getNew(List<T> list,Function<T,R> f){
		List<R> result = new ArrayList<R>();
		for(T t :list){
			result.add(f.apply(t));
		}
		return result;
		
	}
}
