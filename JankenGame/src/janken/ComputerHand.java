package janken;

import java.util.Random;

public class ComputerHand {
	//コンピュータの手を取得するためのメソッド
	static int getComputerHand() {
		//Randomクラスをインスタンス化
		Random random = new Random();
		//handに0〜2のどれかの数値を代入
		int hand = random.nextInt(3);
		//handの値を返す
		return hand;
	}

}