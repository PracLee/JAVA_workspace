package beanFactoryTest;

public class BeanFactory {
	public Object getBean(String beanName) {
		if(beanName.equals("BMW")) {
			return new BMW();
		}else if(beanName.equals("Ferrari")) {
			return new Ferrari();
		}else if(beanName.equals("Benz")) {
			return new Merecedes();
		}
		return null;
	}
}
