package janken;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	//じゃんけんの手の配列を作る
	private static String[] hands = {"グー", "チョキ", "パー"};

	static JLabel contentsLabel;
	static JLabel headerLabel;

	public static void main(String[] args) {
		//JFrameクラスをインスタンス化
		JFrame frame = new JFrame("じゃんけんゲーム");
		//ウィンドウのサイズを指定
		frame.setSize(640, 480);
		//ウィンドウの位置を、画面の中心へ
		frame.setLocationRelativeTo(null);
		//×でアプリが終了するようにする
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ウィンドウのサイズを変更できないようにする
		frame.setResizable(false);
		
		//ヘッダーパネルを作成
		JPanel headerPanel = PanelMaker.makePanel(Color.BLACK, 640, 50);
		//ヘッダーパネルに、レイアウトマネージャとしてBorderLayoutを指定
		headerPanel.setLayout(new BorderLayout());
		//テキストを作成
		headerLabel = TextMaker.makeText("「さあ、じゃんけんで勝負だ！」", 24, Color.WHITE);
		//ヘッダーパネルにテキストを追加
		headerPanel.add(headerLabel);
		//ウィンドウにヘッダーパネルを追加
		frame.add(headerPanel, BorderLayout.NORTH);
		
		//コンテンツパネルを作成
		JPanel contentsPanel = PanelMaker.makePanel(Color.WHITE);
		//コンテンツパネルに、レイアウトマネージャとしてBorderLayoutを指定
		contentsPanel.setLayout(new BorderLayout());
		//テキストを作成
		contentsLabel = TextMaker.makeText("じゃんけん……", 54, Color.BLACK);
		//コンテンツパネルにテキストを追加
		contentsPanel.add(contentsLabel);
		//ウィンドウにコンテンツパネルを追加
		frame.add(contentsPanel, BorderLayout.CENTER);
		
		//フッターパネルを作成
		JPanel footerPanel = PanelMaker.makePanel(Color.BLACK, 640, 50);
		//フッターパネルに、レイアウトマネージャとしてGridLayoutを指定
		footerPanel.setLayout(new GridLayout());

		//じゃんけんの手のボタンを作る
		for (String hand : hands) {
			//JButtonクラスをインスタンス化
			JButton button = new JButton(hand);
			//ボタンのフォントを設定
			button.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 24));
			//ボタンが押されたら、ButtonActionListenerクラスのactionPerformedメソッドを実行
			button.addActionListener(new ButtonActionListener());
			//グーボタンをフッターパネルに追加
			footerPanel.add(button);
		}
		
		//ウィンドウにフッターパネルを追加
		frame.add(footerPanel, BorderLayout.SOUTH);
		
		//ウィンドウを表示する
		frame.setVisible(true);
	}
	
	//ボタンが押されたときのためのクラス
	static class ButtonActionListener implements ActionListener {
		//ボタンが押されたときに呼ばれるメソッド
		public void actionPerformed(ActionEvent e) {
			//コンピュータの手（数値）をランダムに取得
			int computerHandNum = ComputerHand.getComputerHand();
			//数値からコンピュータの手を取り出して代入
			String computerHand = hands[computerHandNum];
			//コンテンツパネルのテキストに、コンピュータの手を指定
			contentsLabel.setText(computerHand);
			//プレイヤーが出した手に対応した数値を入れるための変数
			int playerHandNum=0;
			//プレイヤーが出した手の数値を探してplayerHandNumに入れる
			for (int i=0; i<hands.length; i++) {
				if (hands[i] == e.getActionCommand()) {
					playerHandNum=i;
					break;
				}
			}
			//プレイヤーとコンピュータの手を比べて、結果のセリフを取得
			String serif = Judge.getResultText(playerHandNum, computerHandNum);
			//ヘッダーにセリフを表示
			headerLabel.setText(serif);
		}

	}

}