package model;

public class ProductVO {
	private String productList[]= {"CPU","마우스","Ram","모니터"};
	private int productPrice[]= {350000,100000,80000,1500000};
	public String[] getProductList() {
		return productList;
	}
	public int[] getProductPrice() {
		return productPrice;
	}
	public int printPrice(String productName) {
		int price=0;	// 사용자가 직접입력하지 않는 데이터는 초기화 필수대상!
		for(int i=0; i<productList.length;i++) {
			String data = productList[i];
			if(productName.equals(data)) {
				price = productPrice[i];
				return price;
			}
		}
		return price;
	}
	
}
