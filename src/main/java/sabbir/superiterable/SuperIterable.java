package sabbir.superiterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class SuperIterable<E> implements Iterable<E> {

	private Iterable<E> self;
	
	public SuperIterable(Iterable<E> target) {
		this.self=target;
	}
	
	public <F> SuperIterable<F> flatMap(Function<E,SuperIterable<F>> op){
		List<F> out = new ArrayList<>();
		self.forEach(e -> op.apply(e).forEach(f -> out.add(f)));
		return new SuperIterable<F>(out);
	}
	
	public <F> SuperIterable<F> map(Function<E, F> op){
		List<F> out = new ArrayList<>();
		
//		for (E e: self) {
//			out.add(op.apply(e));
//		}
		
//		or
		
		self.forEach(e -> out.add(op.apply(e)));
		
		return new SuperIterable<F>(out);
	}
	
	public SuperIterable<E> filter(Predicate<E> crit){
		List<E> out = new ArrayList<>();
		for(E e: self){
			if(crit.test(e)) {
				out.add(e);
			}
		}
		return new SuperIterable<>(out);
	}

	/*
	 * same functionality as Iterable.forEach(Consumer<E> op)
	 * @see java.lang.Iterable#iterator()
	 */
//	public void forEvery(Consumer<E> op) {
//		for (E e:self) {
//			op.accept(e);
//		}
//	}
	
	@Override
	public Iterator<E> iterator() {
		return self.iterator();
	}

}
