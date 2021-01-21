//IMPORTING THE NECESSARY PACKAGES
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//BANKS CLASS INHERITS FROM THE JFRAME CLASS AND IMPLEMENTS ACTIONLISTENERS INTERFACE
public class Banks extends JFrame implements ActionListener{

//DECLARATION SECTION

//DECLARING IMAGEICONS FOR THE BUTTONS
	private ImageIcon image1;
	private ImageIcon image2;

	private ImageIcon image3;
	private ImageIcon image4;

	private ImageIcon image5;
	private ImageIcon image6;

//DECLARING COMPONENTS
	private JButton openButton, depositButton, withDrawButton, balanceButton, miniStaButton, closeButton;
	private JToolBar bar;
	private JTextArea txtTextArea;
	private JScrollPane scrBarForTextArea;

//DECLARING THE DIMENSIONS FOR THE BUTTONS
	private Dimension buttonSize = new Dimension(200,50);

//DECLARING COLOR THAT ARE TO BE USED
	private Color blue = new Color(10,110,255);
	private Color white = new Color(255,255,255);

//DECLARING THE FONTS
	private Font head = new Font("Castellar",Font.ITALIC,17);

//DECLARING VARIABLES
	private String strTemp=null;
	private String strAmount = "";
	private float amount = 0;

//CREATING OBJECTS OF OTHER CLASSES
	private Account current = new Account();
	private JAccount joint = new JAccount();

//CONSTRUCTOR FOR THE BANKS CLASS
	public Banks(){
		super("HARSH'S BANKS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add(getScrBarForTextArea(),BorderLayout.CENTER);

		JToolBar bar = new JToolBar(SwingConstants.VERTICAL);

//ADDING BUTTONS TO THE TOOL BAR
		bar.add(getOpenButton());
		bar.add(getDepositButton());
		bar.add(getWithDrawButton());
		bar.add(getBalanceButton());
		bar.add(getMinaStaButton());
		bar.add(getCloseButton());

//DISABLING SOME BUTTONS
		setAllBtnsEnabled(false);

//ADDING ACTION LISTENERS TO ALL THE BUTTONS
		addActionListenerAllBtns();

//ADDING THE BAR TO THE CONTENT PANE
		con.add(bar,BorderLayout.WEST);
	}

//FUNCTION THAT RETURNS A TEXTAREA WITH SOME PROPERTIES SET
private JTextArea getTxtTextArea(){
	if(txtTextArea==null){
		txtTextArea=new JTextArea(10,10);
		txtTextArea.setBackground(white);
		txtTextArea.setForeground(blue);
	   	txtTextArea.setEditable(false);
	   	txtTextArea.setFont(head);
	   	txtTextArea.setText("\t    Harsh's Banks \n\n");
	}
	return txtTextArea;
}


//FUNCTION THAT RETURNS A SCROLLPANE WITH SOME PROPERTIES SET
private JScrollPane getScrBarForTextArea(){
	if(scrBarForTextArea==null){
//VIEWING THE TEXTAREA FROM THE SCROLLPANE
		scrBarForTextArea=new JScrollPane(getTxtTextArea());
	}
	return scrBarForTextArea;
}

//FUNCTION THAT RETURNS A BUTTON WITH SOME PROPERTIES SET
private JButton getOpenButton()
{
	if(openButton==null)
	{
		ImageIcon image1 = new ImageIcon("OPENANACCOUNTANI.gif");
		openButton=new JButton("",image1);
		openButton.setPreferredSize(buttonSize);
    }
	return openButton;
}

//FUNCTION THAT RETURNS A BUTTON WITH SOME PROPERTIES SET
private JButton getDepositButton()
{
	if(depositButton==null)
	{
		ImageIcon image2 = new ImageIcon("DEPOSIT.gif");
		depositButton=new JButton("",image2);
		depositButton.setPreferredSize(buttonSize);
    }
	return depositButton;
}

//FUNCTION THAT RETURNS A BUTTON WITH SOME PROPERTIES SET
private JButton getWithDrawButton()
{
	if(withDrawButton==null)
	{
		ImageIcon image3 = new ImageIcon("WITHDRAW.gif");
		withDrawButton=new JButton("",image3);
		withDrawButton.setPreferredSize(buttonSize);
    }
	return withDrawButton;
}

//FUNCTION THAT RETURNS A BUTTON WITH SOME PROPERTIES SET
private JButton getBalanceButton()
{
	if(balanceButton==null)
	{
		ImageIcon image4 = new ImageIcon("BALANCE.gif");
		balanceButton=new JButton("",image4);
		balanceButton.setPreferredSize(buttonSize);
    }
	return balanceButton;
}

//FUNCTION THAT RETURNS A BUTTON WITH SOME PROPERTIES SET
private JButton getMinaStaButton()
{
	if(miniStaButton==null)
	{
		ImageIcon image5 = new ImageIcon("MINI.gif");
		miniStaButton=new JButton("",image5);
		miniStaButton.setPreferredSize(buttonSize);
    }
	return miniStaButton;
}


//FUNCTION THAT RETURNS A BUTTON WITH SOME PROPERTIES SET
private JButton getCloseButton()
{
	if(closeButton==null)
	{
		ImageIcon image6 = new ImageIcon("CLOSE.gif");
		closeButton=new JButton("",image6);
		closeButton.setPreferredSize(buttonSize);
    }
	return closeButton;
}

//FUNCTION TO ENABLE OR DISABLE BUTTONS
private void setAllBtnsEnabled(boolean bool){
	getDepositButton().setEnabled(bool);
	getWithDrawButton().setEnabled(bool);
	getBalanceButton().setEnabled(bool);
	getMinaStaButton().setEnabled(bool);
	getCloseButton().setEnabled(bool);
}

//FUNCTION TO ADD ACTIONLISTENERS TO BUTTONS
private void addActionListenerAllBtns(){
	getOpenButton().addActionListener(this);
	getDepositButton().addActionListener(this);
	getWithDrawButton().addActionListener(this);
	getBalanceButton().addActionListener(this);
	getMinaStaButton().addActionListener(this);
	getCloseButton().addActionListener(this);
}

//FUNCTION TO SET VARIABLES TO POINT TO NOTHING
private void setVariables(){
	strTemp=null;
	strAmount = "";
	amount = 0;
	current = null;
	joint = null;
}

//THE ACTION PERFORMED METHOD
//EXECUTES WHEN THE CLICK EVENT IS FIRED
public void actionPerformed(ActionEvent e){

		Object source = e.getSource();

//OPEN BUTTON CLICKED
		if(source==openButton){
			String Name = "";
			String ANumber = "";
			String Name2 = "";
			String Name3= "";

//QUERY THE USER FOR THE NEEDED INFORMATION
			do
			{
			 	strTemp = JOptionPane.showInputDialog(null,"Please Enter C To Open A Current Account \n Or J To Open A Joint Account");
			}while(strTemp==null || strTemp.length()==0);
			switch(strTemp.charAt(0)){
				case 'c':
				case 'C':
//ENABLE ALL OTHER BUTTON EXCEPT THE OPEN BUTTON
				setAllBtnsEnabled(true);
				openButton.setEnabled(false);
				do
				{
				Name = JOptionPane.showInputDialog(null,"Please Enter The Account Holder's Name");
				}while(Name==null || Name.length()==0);
				do
				{
				ANumber = JOptionPane.showInputDialog(null,"Please Enter The Account Number");
				}while(ANumber==null || ANumber.length()==0);
				current.openAnAccount(Name,ANumber,"Current Account");
				txtTextArea.append("Current Account Created With The Following Details \n");
				txtTextArea.append("Account Holder's Name:::" + current.getAccountName() + "\n");
				txtTextArea.append("Account Number::::::::::" + current.getAccountNumber()+ "\n");
				txtTextArea.append("Account Sort Code:::::::" + current.getSortCode()+ "\n");
				break;
				case 'j':
				case 'J':
				setAllBtnsEnabled(true);
				openButton.setEnabled(false);
				String choice = null;
				do
				{
				choice = JOptionPane.showInputDialog(null,"Please Enter 2 If They Are 2 Account Holders For The Joint Account \n Or 3 If They Are 3 Account Holders For The Joint Account");
				}while(choice==null || choice.length()==0);
				switch(choice.charAt(0)){
					case '2':
					do
					{
					Name = JOptionPane.showInputDialog(null,"Please Enter The First Account Holder's Name");
					}while(Name==null || Name.length()==0);
					do
					{
					Name2 = JOptionPane.showInputDialog(null,"Please Enter The Second Account Holder's Name");
					}while(Name2==null || Name2.length()==0);
					do
					{
					ANumber = JOptionPane.showInputDialog(null,"Please Enter The Account Number");
					}while(ANumber==null || ANumber.length()==0);
					joint.openAnAccount(Name,Name2,ANumber,"Joint Account");
					txtTextArea.append("Joint Account Created With The Following Details \n");
					txtTextArea.append("First Account Holder's Name:::" + joint.getAccountName() + "\n");
					txtTextArea.append("Second Account Holder's Name:::" + joint.getAccountName2() + "\n");
					txtTextArea.append("Account Number::::::::::" + joint.getAccountNumber()+ "\n");
					txtTextArea.append("Account Sort Code:::::::" + joint.getSortCode()+ "\n");
					break;
					case '3':
					do
					{
					Name = JOptionPane.showInputDialog(null,"Please Enter The First Account Holder's Name");
					}while(Name==null || Name.length()==0);

					do
					{
					Name2 = JOptionPane.showInputDialog(null,"Please Enter The Second Account Holder's Name");
					}while(Name2==null || Name2.length()==0);

					do
					{
					Name3 = JOptionPane.showInputDialog(null,"Please Enter The Third Account Holder's Name");
					}while(Name3==null || Name3.length()==0);

					do
					{
					ANumber = JOptionPane.showInputDialog(null,"Please Enter The Account Number");
					}while(ANumber==null || ANumber.length()==0);

					joint.openAnAccount(Name,Name2,Name3,ANumber,"Joint Account");
					txtTextArea.append("Joint Account Created With The Following Details \n");
					txtTextArea.append("First Account Holder's Name:::" + joint.getAccountName() + "\n");
					txtTextArea.append("Second Account Holder's Name:::" + joint.getAccountName2() + "\n");
					txtTextArea.append("Third Account Holder's Name:::" + joint.getAccountName3() + "\n");
					txtTextArea.append("Account Number::::::::::" + joint.getAccountNumber()+ "\n");
					txtTextArea.append("Account Sort Code:::::::" + joint.getSortCode()+ "\n");
					break;
					default:
					do
					{
					Name = JOptionPane.showInputDialog(null,"Please Enter The First Account Holder's Name");
					}while(Name==null || Name.length()==0);

					do
					{
					Name2 = JOptionPane.showInputDialog(null,"Please Enter The Second Account Holder's Name");
					}while(Name2==null || Name2.length()==0);

					do
					{
					Name3 = JOptionPane.showInputDialog(null,"Please Enter The Third Account Holder's Name");
					}while(Name3==null || Name3.length()==0);

					do
					{
					ANumber = JOptionPane.showInputDialog(null,"Please Enter The Account Number");
					}while(ANumber==null || ANumber.length()==0);					joint.openAnAccount(Name,Name2,Name3,ANumber,"Joint Account");
					txtTextArea.append("Joint Account Created With The Following Details \n");
					txtTextArea.append("First Account Holder's Name:::" + joint.getAccountName() + "\n");
					txtTextArea.append("Second Account Holder's Name:::" + joint.getAccountName2() + "\n");
					txtTextArea.append("Third Account Holder's Name:::" + joint.getAccountName3() + "\n");
					txtTextArea.append("Account Number::::::::::" + joint.getAccountNumber()+ "\n");
					txtTextArea.append("Account Sort Code:::::::" + joint.getSortCode()+ "\n");
				}
				break;
				default:
				setAllBtnsEnabled(true);
				current = new Account();
				do
				{
				Name = JOptionPane.showInputDialog(null,"Please Enter The Account Holder's Name");
				}while(Name==null || Name.length()==0);
				do
				{
				ANumber = JOptionPane.showInputDialog(null,"Please Enter The Account Number");
				}while(ANumber==null || ANumber.length()==0);
				current.openAnAccount(Name,ANumber,"Current Account");
				txtTextArea.append("Current Account Created With The Following Details \n");
				txtTextArea.append("Account Holder's Name:::" + current.getAccountName() + "\n");
				txtTextArea.append("Account Number::::::::::" + current.getAccountNumber()+ "\n");
				txtTextArea.append("Account Sort Code:::::::" + current.getSortCode()+ "\n");
			}
//DEPOSIT BUTTON CLICKED
		}else if(source==depositButton){
			boolean success = false;
			while(success == false){
			try{
			strAmount = JOptionPane.showInputDialog(null,"Please Enter The Amount To Deposit");
			amount = Float.parseFloat(strAmount);
			success = true;
			}catch(Exception am){
				JOptionPane.showMessageDialog(null,"Invalid Numerals Added");
			}
			}
			switch(strTemp.charAt(0)){
				case 'c':
				case 'C':
				current.deposit(amount);
				txtTextArea.append(Float.toString(amount) + " Deposited Into Current Account \n");
				break;
				case 'j':
				case 'J':
				joint.deposit(amount);
				txtTextArea.append(Float.toString(amount) + " Deposited Into Joint Account \n");
				break;
			}
//WITHDRAW BUTTON CLICKED
		}else if(source==withDrawButton){
			boolean success = false;
			while(success == false){
				try{
					strAmount = JOptionPane.showInputDialog(null,"Please Enter The Amount To WithDraw");
					amount = Float.parseFloat(strAmount);
					success = true;
					}catch(Exception amo){
					JOptionPane.showMessageDialog(null,"Invalid Numerals Added");
				}
			}
			switch(strTemp.charAt(0)){
				case 'c':
				case 'C':
				String strTemp2 = current.withDraw(amount);
				txtTextArea.append(strTemp2 + "\n");
				break;
				case 'j':
				case 'J':
				String strTemp3 = joint.withDraw(amount);
				txtTextArea.append(strTemp3 + "\n");
				break;
			}
//BALANCE BUTTON CLICKED
		}else if(source==balanceButton){
			switch(strTemp.charAt(0)){
				case 'c':
				case 'C':
				txtTextArea.append(Float.toString(current.askBalance()) + "\n");
				break;
				case 'j':
				case 'J':
				txtTextArea.append(Float.toString(joint.askBalance()) + "\n");
				break;
			}
//MINI STATEMENT BUTTON CLICKED
		}else if(source==miniStaButton){
			switch(strTemp.charAt(0)){
				case 'c':
				case 'C':
				txtTextArea.append(current.askMiniStatement() + "\n");
				break;
				case 'j':
				case 'J':
				txtTextArea.append(joint.askMiniStatement() + "\n");
				break;
			}
//CLOSE BUTTON CLICKED
		}else if(source==closeButton){
			openButton.setEnabled(true);
			switch(strTemp.charAt(0)){
				case 'c':
				case 'C':
				current.closeAnAccount();
				setVariables();
				System.exit(0);
				break;
				case 'j':
				case 'J':
//SET ALL VARIABLES TO POINT AT NOTHING
				joint.closeAnAccount();
				setVariables();
//EXIT THE SYSTEM
				System.exit(0);
				break;
			}
			txtTextArea.setText("\t    Geniusdip's Banks \n\n");
		}

}

//MAIN METHOD
	public static void main(String[] args){
		Banks fram=new Banks();
		fram.setBounds(0,0,900,500);
		fram.show();
	}



}


//CLASS ACCOUNT TO HANDLE CURRENT ACCOUNT
class Account{
	private String accountName="", accountNumber="", sortCode="";
	private Transaction trans = new Transaction();
	private float amountDeposited=0, amountWithDrawn=0, currentBalance=0;
	private int x=0;

//PUBLIC PROPERTY TO GET ACCOUNT NAME
		public String getAccountName()
		{
			return accountName;
		}

//PUBLIC PROPERTY TO GET ACCOUNT NUMBER
		public String getAccountNumber()
		{
			return accountNumber;
		}

//PUBLIC PROPERTY TO GET SORT CODE
		public String getSortCode()
		{
			return sortCode;
		}

//PUBLIC PROPERTY TO SET ACCOUNT NAME
		public void setAccountName(String accountName)
		{
			this.accountName = accountName;
		}

//PUBLIC PROPERTY TO SET ACCOUNT NUMBER
		public void setAccountNumber(String accountNumber)
		{
			this.accountNumber = accountNumber;
		}

//PUBLIC PROPERTY TO SET SORTCODE
		public void setSortCode(String sortCode)
		{
			this.sortCode = sortCode;
		}

//FUNCTION TO OPEN AN ACCOUNT
		public void openAnAccount(String accountName, String accountNumber, String sortCode)
		{
			this.setAccountName(accountName);
			this.setAccountNumber(accountNumber);
			this.setSortCode(sortCode);
		}

//FUNCTION TO DEPOSIT
		public void deposit(float amountDeposited){
			trans.depositInToAccount(amountDeposited,x);
			x++;
		}

//OVERLOADED FUNCTION TO WITHDRAW WITH ONE ARGUMENT
		public String withDraw(float amountWithDrawn){
			String strWD="";
			if(trans.queryCurrentBalance()>=amountWithDrawn){
				trans.withDrawFromAnAccount(amountWithDrawn,x);
				x++;
				strWD=Float.toString(amountWithDrawn) + " Amount Withdrawn";
			}else{
				strWD="Insufficient Funds In Account";
			}
			return strWD;
		}

//OVERLOADED FUNCTION TO WITHDRAW WITH 2 ARGUMENTS
		public String withDraw(float amountWithDrawn, float overDrawnAmount){
				trans.withDrawFromAnAccount(amountWithDrawn,x);
				x++;
				return Float.toString(overDrawnAmount);
		}

//FUNCTION TO RETURN CURRENT BALANCE
		public float askBalance(){
			float balance = trans.queryCurrentBalance();
			return balance;
		}

//FUNCTION TO RETURN MINI STATEMENT
		public String askMiniStatement(){
			String strStatement = trans.showMiniStatement();
			return strStatement;
		}

//FUNCTION TO CLOSE AN ACCOUNT
		public void closeAnAccount()
		{
			setAccountName(null);
			setAccountNumber(null);
			setSortCode(null);
			trans = null;
		}

//FUNCTION THAT RETURNS THE NEXT TRANSACTION NUMBER
		public int getX(){
			x++;
			return x;
		}
}



//CLASS TRANSACTIONS FOR ALL THE BANKING TRANSACTIONS
//INCLUDING ASK BALANCE, DEPOSIT, WITHDRAW & MINI STATEMENT
class Transaction{


private float amountDeposited=0, amountWithDrawn=0, currentBalance=0;
private float[] transactionAmount = new float[10];
private int[] transactionNumber = new int[10];
private String[] transactionType = new String[10];

public void depositInToAccount(float amountDeposited, int transactionNumber) throws IndexOutOfBoundsException
{
	try{
	if(amountDeposited>0)
		{
			this.amountDeposited = amountDeposited;
			this.currentBalance = this.currentBalance + amountDeposited;
			if(transactionNumber > 9){
				for(int i=0;i<9;++i){
//REINITIALIZE THE ARRAY IF THE TRANSACTION NUMBER IS > 9
//ALL THE ELEMENTS SHOULD GO ONE STEP BACK WARDS
//THE FIRST ELEMENT IS DELETED
					this.transactionNumber[i] = this.transactionNumber[i+1];
					this.transactionType[i] = this.transactionType[i+1];
					this.transactionAmount[i] = this.transactionAmount[i+1];
				}
//THE NEW ELEMENT IS ADDED AT THE END
				this.transactionNumber[9] = transactionNumber;
				this.transactionType[9] = "Deposited";
				this.transactionAmount[9] = amountDeposited;
			}else{
//ELSE JUST ADD IT AT THE INDEX SPECIFIED
				this.transactionNumber[transactionNumber] = transactionNumber;
				this.transactionType[transactionNumber] = "Deposited";
				this.transactionAmount[transactionNumber] = amountDeposited;
			}
		}
	}catch(IndexOutOfBoundsException a){

	}
}

//WITHDRAW FROM ACCOUNT FUNCTION
public String withDrawFromAnAccount(float amountWithDrawn,int transactionNumber)
{
	String strWithDraw="";
	currentBalance = currentBalance - amountWithDrawn;
	if(transactionNumber > 9){
//REINITIALIZE THE ARRAY IF THE TRANSACTION NUMBER IS > 9
//ALL THE ELEMENTS SHOULD GO ONE STEP BACK WARDS
//THE FIRST ELEMENT IS DELETED
		for(int i=0;i<9;i++){
			this.transactionNumber[i] = this.transactionNumber[i+1];
			this.transactionType[i] = this.transactionType[i+1];
			this.transactionAmount[i] = this.transactionAmount[i+1];
		}
//THE NEW ELEMENT IS ADDED AT THE END
			this.transactionNumber[9] = transactionNumber;
			this.transactionType[9] = "Withdrawn";
			this.transactionAmount[9] = amountWithDrawn;
		}else{
//ELSE JUST ADD IT AT THE INDEX SPECIFIED
			this.transactionNumber[transactionNumber] = transactionNumber;
			this.transactionType[transactionNumber] = "Withdrawn";
			this.transactionAmount[transactionNumber] = amountWithDrawn;
	}
	return strWithDraw;
}

//ASK FOR BALANCE FUNCTION
public float queryCurrentBalance()
{
	return currentBalance;
}

//SHOW MINI STATEMENT FUNCTION RETURN A STRING WITH THE
//LAST 10 TRANSACTIONS
public String showMiniStatement() throws IndexOutOfBoundsException
{
	String str="Transaction Number \t Transaction Type \t Transaction Amount \n";
	try{
		for(int i = 0;i<=9;++i){
			str = str + Integer.toString(this.transactionNumber[i]) +"\t\t"+ this.transactionType[i] +"\t\t"+ Float.toString(this.transactionAmount[i])+"\n";
		}
	}finally{
	return str;
	}
}


}


//THE JACCOUNT CLASS INHERITS FROM THE ACCOUNT CLASS
//TO HANDLE JOINT ACCOUNT
class JAccount extends Account{

	private String accountName2="";
	private String accountName3="";

//PUBLIC SET ACCOUNT NAME 2 PROPERTY
	public String getAccountName2()
	{
		return accountName2;
	}

//PUBLIC GET ACCOUNT NAME 3 PROPERTY
	public String getAccountName3()
	{
		return accountName3;
	}

//PUBLIC SET ACCOUNT NAME 2 PROPERTY
	public void setAccountName2(String accountName2)
	{
		this.accountName2 = accountName2;
	}

//PUBLIC SET ACCOUNT NAME 3 PROPERTY
	public void setAccountName3(String accountName2)
	{
		this.accountName3 = accountName2;
	}

//OVERRIDING & OVERLOADING THE OPENANACOUNT FUNCTION
	public void openAnAccount(String accountName,String accountName2,String accountName3, String accountNumber, String sortCode)
	{
		this.setAccountName2(accountName2);
		this.setAccountName3(accountName3);
		super.openAnAccount(accountName,accountNumber,sortCode);
	}

//OVERRIDING & OVERLOADING THE OPENANACOUNT FUNCTION
	public void openAnAccount(String accountName,String accountName2, String accountNumber, String sortCode)
	{
		this.setAccountName2(accountName2);
		super.openAnAccount(accountName,accountNumber,sortCode);
	}

//OVERRIDING THE WITHDRAW FUNCTION
	public String withDraw(float amountWithDrawn){
		String strWD="";
		float test = askBalance()-amountWithDrawn;
		if(test>=0){
			strWD=super.withDraw(amountWithDrawn);
		}else if(test>=-5000 & test<0){
			super.withDraw(amountWithDrawn,test);
			strWD="Amount Withdrawn Utilized Over Draft Facility";
		}else{
			strWD="Insufficient Funds In Account Even With Over Draft Facility";
		}
		return strWD;
	}

//FUNCTION TO CLOSE THE ACCOUNT
	public void closeAnAccount(){
		setAccountName2("");
		setAccountName3("");
		super.closeAnAccount();
	}
}