package com.summary.SummaryYogaDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@FunctionalInterface
interface SampleInfo {
	int getAdd(int a, int b);
}

interface SampleMethod {
	List<Product> getVealues();
}

class Product {
	Integer id;
	String name;
	Float price;

	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	} 
}

public class LambdaExpression {
	public static void main(String[] args) {
		// Syntax for LambdaExpression is : (argument-list) -> {body}
		Set<Product> sampleSet = new HashSet<Product>();
		sampleSet.add(new Product(1, "Samsung A5", 17000f));
		sampleSet.add(new Product(3, "Iphone 6S", 65000f));
		sampleSet.add(new Product(2, "Sony Xperia", 25000f));
		sampleSet.add(new Product(4, "Nokia Lumia", 15000f));
		sampleSet.add(new Product(5, "Redmi4 ", 26000f));
		sampleSet.add(new Product(6, "Lenevo Vibe", 19000f));
		System.out.println("Before size: "+sampleSet.size());
		for (Product product : sampleSet) {
			product.setId(product.getId() == 1?123:product.getId());
			sampleSet.add(product);
		}
		System.out.println("After size: "+sampleSet.size());
		
		
		
		
		// Lambda Expression Example: Foreach Loop
		List<String> list = new ArrayList<String>();
		list.add("ankit");
		list.add("mayank");
		list.add("irfan");
		list.add("jai");
		
		/*Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			String value =iterator.next();
			System.out.println(value+" is : "+value.equals("jai"));
			if(value.equals("jai"))
				iterator.remove();
		}
		System.out.println(list);*/
		
		/*for (String string : list) {
			if(string.equals("jai"))
				list.remove(string);
		}*/
		System.out.println(list);
		//Exception in thread "main" java.util.ConcurrentModificationException
		list.forEach((n) -> System.out.println(n));

		System.out.println("=====================");
		SampleInfo sample1 = (a, b) -> {
			return (a + b);
		}; // Lambda expression with return keyword.
		SampleInfo sample = (a, b) -> (a + b); // Lambda expression without
												// return keyword.
		System.out.println("sample1 : " + sample1.getAdd(3, 4) + " sample : " + sample.getAdd(31, 44));

		// Thread Example without lambda
		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println("Thread1 is running...");
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();
		// Thread Example with lambda
		Runnable r2 = () -> {
			System.out.println("Thread2 is running...");
		};
		Thread t2 = new Thread(r2);
		t2.start();
		
		
		//Labda expression with sorting a list using Comparator
		getListComparator(getListContent());
		
		// using lambda to filter data
		System.out.println("\nfilterCollectionData\n==================================");
		filterCollectionData(getListContent());
		
		System.out.println("\nMethod Refferance Static\n==================================");
		//Method Refferance Static
		SampleMethod  sample123 = LambdaExpression::getListContent;
		sample123.getVealues().forEach(product -> System.out.println("Product Name : "+product.id+" Product Name : "+product.name+" Product Price : "+product.price));;
		
		System.out.println("\nListIteration with filteration\n==================================");
		SampleMethod  sampleList = LambdaExpression::getListContent;
		getListIteration(sampleList.getVealues());
		Character[] charArray = {'a','q','b','c','d','f','g','r','t','a','w','e','a','b','s','d','a','c','d','f','r','g','t','y','z','x','x','z','s','d','a','b','f'};
		List<Character> carList =Arrays.asList(charArray);
		
		//Java 1.6
		
		Map<Character,Long> findDuplicates = new HashMap<>();
		for (Character character : carList) {
			findDuplicates.put(character, findDuplicates.get(character)==null?1:findDuplicates.get(character)+1);
		}
		System.out.println("findDuplicates : "+findDuplicates);
		//Single Line 
		carList.stream().collect( Collectors.groupingBy( c -> c, Collectors.counting() ) ).entrySet().parallelStream().filter(obj -> obj.getValue()>1).forEach(obj -> {
			System.out.println(""+obj.getKey()+" = "+obj.getValue() );
		});;
		
		System.out.println("=================================");
		Map<Character, Long> collect = 
				carList.stream().filter(obj->obj.equals('c')).collect( Collectors.groupingBy( c -> c, Collectors.counting() ) );
		collect.entrySet().parallelStream().filter(obj -> obj.getValue()>1).forEach(obj -> {
			System.out.println(""+obj.getKey()+" = "+obj.getValue() );
		});
		
		  sampleList = LambdaExpression::getListContent;
		List<Product> listDetails = sampleList.getVealues();
		listDetails.addAll(sampleList.getVealues());
		
		System.out.println("=================================");
		Map<String, Long>  details = listDetails.parallelStream().collect(Collectors.groupingBy(Product::getName,Collectors.counting()));
		System.out.println("details : "+details);
		
		
		System.out.println("=================================");
		
		System.out.println(new Product().getName()+"" == null ?true:false);
	}
	
	
	private static void getListIteration(List<Product> productsList){
	        // This is more compact approach for filtering data  
	        productsList.stream()  
	                             .filter(product -> product.price >= 25000)  
	                             .forEach(product -> System.out.println(product.name));
	        
	        
	        
	        Float totalPrice = productsList.stream()  
                    .map(product->product.price)  
                    .reduce(0.0f,(sum, price)->sum+price);   // accumulating price  
        System.out.println(totalPrice);  
        // More precise code   
        float totalPrice2 = productsList.stream()  
                .map(product->product.price)  
                .reduce(0.0f,Float::sum);   // accumulating price, by referring method of Float class  
        System.out.println(totalPrice2);  
        
        
        //sum by using Collectors
        double totalPrice3 = productsList.stream()  
                .collect(Collectors.summingDouble(product->product.price));  
        System.out.println(totalPrice3);  
        
     // max() method to get max Product price  
        Product productA = productsList.stream()  
                .max((product1, product2)->   
                product1.price > product2.price ? 1: -1).get(); 
        
        System.out.println(productA.name+"  "+productA.price);  
        
        
        // min() method to get min Product price  
        Product productB = productsList.stream()  
                .max((product1, product2)->   
                product1.price < product2.price ? 1: -1).get();  
        System.out.println(productA.name+"  "+productB.price);  
        
        
        // Converting Product List into a Map  
        Map<Integer,Object> productPriceMap =   
            productsList.stream()  
                        .collect(Collectors.toMap(p->p.id, p->p));  
              
        System.out.println(productPriceMap);  
        
        
     // Converting product List into Set  
        Set<Float> productPriceList =   
            productsList.stream()  
            .filter(product->product.price < 30000)   // filter product on the base of price  
            .map(product->product.price)  
            .collect(Collectors.toSet());   // collect it as Set(remove duplicate elements)  
        System.out.println(productPriceList);
        
        //Method Reference in stream
        List<Float> productPriceList1 =   
                productsList.stream()  
                            .filter(p -> p.price > 30000) // filtering data  
                            .map(Product::getPrice)         // fetching price by referring getPrice method  
                            .collect(Collectors.toList());  // collecting as list  
        System.out.println(productPriceList1);  
    }  
	

	private static void getListComparator(List<Product> listSort ) {
		// Labda expression with sorting a list using Comparator
		System.out.println(
				"=====================\nLabda expression with sorting a list using Comparator\n--------------------------");
		String[] orderArray = { "ASC", "DESC" };
		String[] array = { "ID", "NAME", "PRICE" };
		for (int i = 0; i < orderArray.length; i++) {

			for (int j = 0; j < array.length; j++) {
				String sortBy = array[j];
				System.out.println("\nSort By : " + array[j] + "  Sort Order type - " + orderArray[i]
						+ "\n=======================");
				if (orderArray[i].equalsIgnoreCase("DESC")) {
					// implementing lambda expression
					Collections.sort(listSort, (p1, p2) -> {
						if (sortBy.equalsIgnoreCase("ID"))
							return -p1.id.compareTo(p2.id);
						else if (sortBy.equalsIgnoreCase("NAME"))
							return -p1.name.compareTo(p2.name);
						else
							return -p1.price.compareTo(p2.price);
					});
				} else {
					// implementing lambda expression
					Collections.sort(listSort, (p1, p2) -> {
						if (sortBy.equalsIgnoreCase("ID"))
							return p1.id.compareTo(p2.id);
						else if (sortBy.equalsIgnoreCase("NAME"))
							return p1.name.compareTo(p2.name);
						else
							return p1.price.compareTo(p2.price);
					});
				}
				for (Product p : listSort) {

					System.out.println(p.id + " " + p.name + " " + p.price);
				}
			}
		}

	}

	private static void filterCollectionData(List<Product> list) {
		// using lambda to filter data
		Stream<Product> filtered_data = list.parallelStream().filter(p -> p.price > 20000);

		// using lambda to iterate through collection
		filtered_data.forEach(product -> System.out.println(product.name + ": " + product.price));
	}

	public static List<Product> getListContent() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "Samsung A5", 17000f));
		list.add(new Product(3, "Iphone 6S", 65000f));
		list.add(new Product(2, "Sony Xperia", 25000f));
		list.add(new Product(4, "Nokia Lumia", 15000f));
		list.add(new Product(5, "Redmi4 ", 26000f));
		list.add(new Product(6, "Lenevo Vibe", 19000f));
		return list;
	}

}
