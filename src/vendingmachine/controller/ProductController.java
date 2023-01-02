package vendingmachine.controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vendingmachine.view.ProductView;
import vendingmachine.vo.ProductDAO;
import vendingmachine.vo.ProductVO;

public class ProductController extends JFrame{
	ArrayList<ProductVO> productList;
	public static final int STOP = 0;
	
	public ProductController() {
		
//		자판기 화면 출력
		ProductView view = new ProductView();
		fullProduct();
		view.setProductList(productList);
		JPanel panC = view.displayProducts(this);
		JPanel panS = view.inputPurchase();
		add(panC, "Center");
		add(panS, "South");
		
		setTitle("음료자판기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,20,600,700);
		setVisible(true);
		setResizable(false);
	}
	
	

	public void fullProduct() {
//		자판기에 제품 채우기
		ProductDAO dao = new ProductDAO();
		String[] names = {"cider", "cola", "orangewelchs", "grapewelchs", "zerocola", "greenplum", "orangejuice", "viraksikhye", "vita500"}; 
		int[] prices = {800, 900, 1100, 1100, 1500, 1600, 2000, 1000, 700};
		ProductVO vo = null;
		productList = dao.select();
		for (int i=0; i<names.length; i++) {
			vo = new ProductVO();
			vo.setName(names[i]);
			vo.setPrice(prices[i]);
			vo.setProductNum(i);
			vo.setStockNum(10);
			vo.setImageName(names[i]);
			productList.add(vo);
		}
	}
	
	public static void main(String[] args) {
		new ProductController();
	}

}