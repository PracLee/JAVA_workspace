package model;

public class ProductVO {
	private String productList[]= {"CPU","���콺","Ram","�����"};
	private int productPrice[]= {350000,100000,80000,1500000};
	public String[] getProductList() {
		return productList;
	}
	public int[] getProductPrice() {
		return productPrice;
	}
	public int printPrice(String productName) {
		int price=0;	// ����ڰ� �����Է����� �ʴ� �����ʹ� �ʱ�ȭ �ʼ����!
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
