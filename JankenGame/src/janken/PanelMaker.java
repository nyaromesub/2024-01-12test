package janken;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanelMaker {
	
	//パネルを作るメソッド（幅と高さを指定する用）
	static JPanel makePanel(Color color, int width, int height) {
		//JPanelクラスをインスタンス化
		JPanel panel = new JPanel();
		//パネルの色を変更する
		panel.setBackground(color);
		//パネルのサイズを「width、height」に設定
		panel.setPreferredSize(new Dimension(width, height));
		//作ったパネルを返す
		return panel;
	}
	
	//パネルを作るメソッド（幅と高さを指定しない用）
	static JPanel makePanel(Color color) {
		//JPanelクラスをインスタンス化
		JPanel panel = new JPanel();
		//パネルの色を変更する
		panel.setBackground(color);
		//作ったパネルを返す
		return panel;
	}

}