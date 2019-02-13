package qa.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoLambda {

	public static void main(String[] args) {

		JFrame	f = new JFrame("Demo Lambda");
		JPanel p = new JPanel();
		f.setSize(300,200);

		JButton bOk = new JButton("OK") ;
		JButton bCancel = new JButton("Cancel") ;

//		MyButtonClickedListener l = new MyButtonClickedListener() ;
//		MyButtonCancelListener l2 = new MyButtonCancelListener() ;
//		bOk.addActionListener(l);
//		bCancel.addActionListener(l);
//		bCancel.addActionListener(l2);

//		bOk.addActionListener(new ActionListener () {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Anonymous Class OK clicked event");
//
//			}
//
//		});
//		bCancel.addActionListener(new ActionListener () {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Anonymous Class 1 Cancel clicked event");
//
//			}
//
//		});
//		bCancel.addActionListener(new ActionListener () {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Anonymous Class 2 Cancel clicked event");
//
//			}
//
//		});

		bOk.addActionListener( e -> System.out.println("OK Lambda Clicked"));
		bCancel.addActionListener( e -> System.out.println("Cancel Lambda Clicked"));
		bCancel.addActionListener( x -> {
			System.out.println("Cancel Lambda 2 Clicked");
			System.out.println("Cancel Lambda 3 Clicked");
			
		});


		p.add(bOk) ;
		p.add(bCancel);
		f.add(p);

		f.setVisible(true);
	}


	static class MyButtonClickedListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Action Clicked from class...");

		}

	}

	static class MyButtonCancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Action Clicked from Cancel Listener class...");

		}

	}

}
