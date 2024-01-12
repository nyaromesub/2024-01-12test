package janken;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TextMaker {
	
	//テキストを作るメソッド
	static JLabel makeText(String str, int size, Color color) {
		//JLabelクラスをインスタンス化
		JLabel label = new JLabel(str);
		//テキストの文字を白にする
		label.setForeground(color);
		//テキストのフォントを設定
		label.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, size));
		//テキストの位置を、水平方向の中心にする
		label.setHorizontalAlignment(JLabel.CENTER);
		//テキストの位置を、垂直方向の中心にする
		label.setVerticalAlignment(JLabel.CENTER);
		//作ったテキストを返す
		return label;
	}

}