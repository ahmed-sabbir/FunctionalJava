package sabbir.generic;

public interface Predicate<E> {
	
	boolean test(E s);
	
	default Predicate<E> negate(){
		return s -> !this.test(s);
	}
	
	default  Predicate<E> and(Predicate<E> criteria){
		return s -> this.test(s) && criteria.test(s);
	}
	
	default Predicate<E> or(Predicate<E> criteria){
		return s -> this.test(s) || criteria.test(s);
	}

}
