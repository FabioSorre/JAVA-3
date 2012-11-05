import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main implements ActionListener, KeyListener {

	private JFrame f;
	private JPanel p;
	private JLabel l;
	private JButton [] butt = new JButton[20];
	private double numero;
	private double num1;
	private double num2;
	private boolean z=false;
	private boolean z1=false;
	private boolean z2=false;
	private int check=0;
	
	public Main () {
		f=new JFrame("Calculator");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		p=new JPanel ();
		p.setLayout(new GridLayout (4,5,12,10));
		String []ls=new String[]{
				"7","8","9","+","C","4","5","6","-","√","1","2","3","×","1/x","0",",","±","÷","="};
		
		int i=0;
		for(String s:ls)
		{
			butt[i]=new JButton(s);
			butt[i].addActionListener(this);
			butt[i].setFocusable(false);
			p.add(butt[i]);
			i++;
		}
		
		p.setFocusable(true);
		p.requestFocus();
		p.addKeyListener(this);
		p.setPreferredSize(new Dimension(400, 400));
		l=new JLabel("0");
		l.setHorizontalAlignment(JLabel.RIGHT);
		l.setFont(l.getFont().deriveFont(30.0f));
		f.add(l, BorderLayout.NORTH);
			f.add(p);
			f.pack();
			f.setVisible(true);
		    		

	}
	
		
	public static void main(String[] args) {
		Runnable r=new Runnable() {
			public void run() {
				new Main();
			}
		};
		EventQueue.invokeLater(r);
	}

	
	
	public void actionPerformed(ActionEvent ae) {
		
		String b=((AbstractButton) ae.getSource()).getText();
		if(b.equals("+"))
		{
			z2=false;
			numero=Double.parseDouble(l.getText());
			l.setText(""+numero);
			check=0;
			if(!z)
			{
				num1= numero; 
				System.out.println(num1);
				numero = 0;
				z=true;
			}
			else
			{
				num2=numero;
				num1=(num1)+(num2);
				System.out.println(num2);
				numero = 0;
				l.setText("" + (num1));
			}
			
				
		}
		
		else if(b.equals("-"))
		{
			z2=false;
			numero=Double.parseDouble(l.getText());
			l.setText(""+numero);
			check=1;
			if(!z)
			{
				num1= numero; 
				System.out.println(num1);
				numero = 0;
				z=true;
			}
			else
			{
				num2=numero;
				num1=(num1)-(num2);
				System.out.println(num2);
				numero = 0;
				l.setText("" + (num1));
			}
		}
		else if(b.equals("×"))
		{
			z2=false;
			numero=Double.parseDouble(l.getText());
			l.setText(""+numero);
			check=2;
			if(!z)
			{
				num1= numero; 
				System.out.println(num1);
				numero = 0;
				z=true;
			}
			else
			{
				num2=numero;
				num1=(num1)*(num2);
				System.out.println(num2);
				numero = 0;
				l.setText("" + (num1));
			}
		}
		else if(b.equals("÷"))
		{
			z2=false;
			numero=Double.parseDouble(l.getText());
			l.setText(""+numero);
			check=3;
			if(!z)
			{
				num1= numero; 
				System.out.println(num1);
				numero = 0;
				z=true;
			}
			else
			{
				num2=numero;
				num1=(num1)/(num2);
				System.out.println(num2);
				if(num2==0)
				{
					l.setText("Errore (÷ per zero)");
					z1=true;
					num1 = num2 = numero = 0;
				}
				
				if(!z1)
				{
					numero = 0;
					l.setText("" + (num1));
				}
				
				z1=false;
			}
		}
		else if(b.equals("±"))
		{
			numero = Double.parseDouble(l.getText());
			if(numero<0)
				numero=numero*(-1);
			else if(numero>0)
				numero=(-numero);
			l.setText(""+numero);
		}
		else if(b.equals("1/x"))
		{
			z2=false;
			numero = Double.parseDouble(l.getText());
			double n=0;
			n=1/numero;
			l.setText(""+n);
			z=true;
			if(numero==0)
			{
				l.setText("Errore (÷ per zero)");
			}
			numero=n;
			z2=true;
		}
		else if(b.equals("C"))
		{
			l.setText("0");
			numero=0;
			num1 = num2 = 0;
		}
		else if(b.equals("√"))
		{
			z2=false;
				numero = Double.parseDouble(l.getText());
				double n=0;
				n=Math.sqrt(numero);
				numero=n;
				l.setText(""+n);
				if(numero<0)
				{
					l.setText("Radice di num negativo");
				}
				z2=true;
		}
		else if(b.equals(","))
		{
			l.setText(l.getText()+".");	
		}
		else if(b.equals("="))
		{
			numero=Double.parseDouble(l.getText());
			switch(check)
			{
				case 0: 
					if(z)
					{
					
						num2=numero;
						System.out.println(num2);
						
						l.setText("" + ((num1)+(num2)));
						numero = Double.parseDouble(l.getText());
						z=false;
						
					}
					else
					{
						num1=numero;
						
						l.setText("" + ((num1)+(num2)));
						numero = Double.parseDouble(l.getText());
					}
					
					break;
					
				case 1: 
					if(z)
					{
						num2=numero;
						System.out.println(num2);
						
						l.setText("" + ((num1)-(num2)));
						numero = Double.parseDouble(l.getText());
						z=false;
						
					}
					else
					{
						num1=numero;
						
						l.setText("" + ((num1)-(num2)));
						numero = Double.parseDouble(l.getText());
					}
					
					break;
					
				case 2:
					if(z)
					{
						num2=numero;
						System.out.println(num2);
						
						l.setText("" + ((num1)*(num2)));
						numero = Double.parseDouble(l.getText());
						z=false;
						
					}
					else
					{
						num1=numero;
						
						l.setText("" + ((num1)*(num2)));
						numero = Double.parseDouble(l.getText());
					}
					
					break;
					
				case 3:
					if(z)
					{
						num2=numero;
						System.out.println(num2);
						
						if(num2==0)
						{
							l.setText("Errore (÷ per zero)");
							z1=true;
							num1 = num2 = numero = 0;
						}
						//mi stampa il risultato sulla label
						if(!z1)
						{
							l.setText("" + ((num1)/(num2)));
							numero = Double.parseDouble(l.getText());
							z=false;
						}
						
						z1=false;
										
					}
					else
					{
						num1=numero;
						
						l.setText("" + ((num1)/(num2)));
						numero = Double.parseDouble(l.getText());
					}
					
					break;
			
															
			}
			
			z2=true;
		}
		else
		{	//resetto il numero nel caso in cui dopo aver effettuato un operazione clicco un altro numero
			//e questo non mi viene accodato al risultato dell'operazione precedente
			if(z2)
			{
				l.setText("0");
				numero=0;
				num1 = num2 = 0;
				z2=false;
			}
			if(l.getText().equals("0"))
			{
				l.setText(b);
				
			}
			else if(l.getText().equals("" +num1))
			{
				l.setText(b);
				
			}
			else 
			{//concateno i numeri 
				String nS=l.getText()+b;
				l.setText(nS);
			}
		}
		
	}


	@Override
	public void keyReleased(KeyEvent ke) {
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
	}


	@Override
	public void keyPressed(KeyEvent e) {
		char c=e.getKeyChar();
		switch (c){
		case '0': 
			butt[15].doClick();
			break;
		case '1':
			butt[10].doClick();
			break;
		case '2':
			butt[11].doClick();
			break;
		case '3':
			butt[12].doClick();
			break;
		case '4':
			butt[5].doClick();
			break;
		case '5':
			butt[6].doClick();
			break;
		case '6':
			butt[7].doClick();
			break;
		case '7':
			butt[0].doClick();
			break;
		case '8':
			butt[1].doClick();
			break;
		case '9':
			butt[2].doClick();
			break;
		case '=':
			butt[19].doClick();
			break;
		case '+':
			butt[3].doClick();
			break;
		case '-':
			butt[7].doClick();
			break;
		case '*':
			butt[13].doClick();
			break;
		case '/':
			butt[18].doClick();
			break;
		case 'C':
			butt[4].doClick();
			break;
		case '.':
			butt[16].doClick();
			break;
		}
	}
	
}
