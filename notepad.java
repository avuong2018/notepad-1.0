 import java.io.*;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 
 public class notepad extends JFrame implements ActionListener {
 	private JFileChooser fc = new JFileChooser();
 	private JTextArea dat;
 	private JMenuBar menu = new JMenuBar();
 	private JMenu file, edit, format, font, bg, fg, help;
 	private JMenuItem nu, open, saveas, exit, copy, paste, clear, about, b8, b12, b14, b16, b18, b20, b22, by, bc, bgr, fb, fr, fbl;
 	
 	final static String LOOKANDFEEL = null;
 	
 	public notepad() {
 		setLocation(200, 200);
 		setTitle("Notepad - Written by Anh Vuong - Troy University");
 		setSize(new Dimension(500, 500));
 		setDefaultCloseOperation(EXIT_ON_CLOSE);
 		
 		file = new JMenu("File");
 		menu.add(file);
 		
 		nu = new JMenuItem("new");
 		file.add(nu);
 		nu.addActionListener(this);
 		
 		open = new JMenuItem("open");
 		file.add(open);
 		open.addActionListener(this);
 		
 		saveas = new JMenuItem("save as");
 		file.add(saveas);
 		saveas.addActionListener(this);
 		
 		exit = new JMenuItem("exit");
 		file.add(exit);
 		exit.addActionListener(this);
 		
 		edit = new JMenu("Edit");
 		menu.add(edit);
 		
 		format = new JMenu("Style");
 		menu.add(format);
 		
 		help = new JMenu("Information");
 		menu.add(help);
 		
 		copy = new JMenuItem("copy");
 		edit.add(copy);
 		copy.addActionListener(this);
 		
 		paste = new JMenuItem("paste");
 		edit.add(paste);
 		paste.addActionListener(this);
 		
 		clear = new JMenuItem("clear");
 		edit.add(clear);
 		clear.addActionListener(this);
 		
 		font = new JMenu("font");
 		format.add(font);
 		font.addActionListener(this);
 		
 		b8 = new JMenuItem("8");
 		font.add(b8);
 		b8.addActionListener(this);
 		
 		b12 = new JMenuItem("12");
 		font.add(b12);
 		b12.addActionListener(this);
 		
 		b14 = new JMenuItem("14");
 		font.add(b14);
 		b14.addActionListener(this);
 		
 		b16 = new JMenuItem("16");
 		font.add(b16);
 		b16.addActionListener(this);
 		
 		b18 = new JMenuItem("18");
 		font.add(b18);
 		b18.addActionListener(this);
 		
 		b20 = new JMenuItem("20");
 		font.add(b20);
 		b20.addActionListener(this);
 		
 		b22 = new JMenuItem("22");
 		font.add(b22);
 		b22.addActionListener(this);
 		
 		bg = new JMenu("Background");
 		format.add(bg);
 		
 		by = new JMenuItem("Yellow");
 		by.addActionListener(this);
 		bg.add(by);
 		
 		bc = new JMenuItem("Cyan");
 		bc.addActionListener(this);
 		bg.add(bc);
 		
 		bgr = new JMenuItem("Green");
 		bgr.addActionListener(this);
 		bg.add(bgr);
 		
 		fg = new JMenu("Text Color");
 		format.add(fg);
 		
 		fb = new JMenuItem("Black");
 		fb.addActionListener(this);
 		fg.add(fb);
 		
 		fr = new JMenuItem("Red");
 		fr.addActionListener(this);
 		fg.add(fr);
 		
 		fbl = new JMenuItem("Blue");
 		fbl.addActionListener(this);
 		fg.add(fbl);
 		
 		about = new JMenuItem("about");
 		help.add(about);
 		about.addActionListener(this);
 		
 		dat = new JTextArea(8, 8);
 		
 		JPanel spane = new JPanel(new GridLayout(0, 1));
 		spane.add(dat);
 		
 		JScrollPane sp = new JScrollPane(spane);
 		
 		JPanel mpane = new JPanel(new GridLayout(0, 1));
 		getContentPane().add(sp);
 		setJMenuBar(menu);
 	}
 	public void actionPerformed(ActionEvent e) {
 		if (e.getSource() == nu) {
 			int nuask = JOptionPane.showConfirmDialog(notepad.this,"This will clear any unsaved documents. Do you really want to do it?");
 			if (nuask == JOptionPane.YES_OPTION) {
 				dat.setText("");
 			}
 		}
 		if (e.getSource() == open) {
 			int returnVal = fc.showOpenDialog(notepad.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
               File file = fc.getSelectedFile();
               try {
                   BufferedReader inputStream = new BufferedReader(new FileReader(file.getPath()));
                   String inputLine;
                   dat.setText("");
                   setTitle("notepad-"+file.getName());
                   while((inputLine = inputStream.readLine()) != null) {
                         dat.append(inputLine+"\n");
                   }
               }
               catch(FileNotFoundException ioe) {
                    JOptionPane.showMessageDialog(null, "Sorry, file was not found", "", JOptionPane.WARNING_MESSAGE );
               }
               catch(IOException ioe) {
                    System.out.println(file.getAbsoluteFile());
               }
            }
 		}
 		
 		if (e.getSource() == saveas) {
 			int returnVal = fc.showSaveDialog(notepad.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fc.getSelectedFile();
                    FileWriter outputStream=new FileWriter(file.getPath()+".txt");        				
                    setTitle("notepad-"+file.getName());
                    outputStream.write(dat.getText());
                    outputStream.close();
                }
                catch(IOException ioe) {
                     System.out.println("IOException");
                }
            }
 		}
 		if (e.getSource() == exit) {
 			int aske = JOptionPane.showConfirmDialog(notepad.this,"Do you really want to exit " +getTitle() + " ?");
 			if (aske == JOptionPane.YES_OPTION) {
 				System.exit(0);
 			}
 		}

 		if (e.getSource() == copy) {
 			dat.copy();
 		}
 		if (e.getSource() == paste) {
 			dat.paste();
 		}
 		if (e.getSource() == clear) {
 			int cask = JOptionPane.showConfirmDialog(notepad.this,"Do you really want to clear the document?");
 			if (cask == JOptionPane.YES_OPTION) {
 				dat.setText("");
 				setTitle("Notepad - Written by Anh Vuong - Troy University");
 			}
 		}
 		if (e.getSource() == b8) {
 			dat.setFont(new Font(dat.getFont().getName(),dat.getFont().getStyle(),8));
 		}
 		if (e.getSource() == b12) {
 			dat.setFont(new Font(dat.getFont().getName(),dat.getFont().getStyle(),12));
 		}
 		if (e.getSource() == b14) {
 			dat.setFont(new Font(dat.getFont().getName(),dat.getFont().getStyle(),14));
 		}
 		if (e.getSource() == b16) {
 			dat.setFont(new Font(dat.getFont().getName(),dat.getFont().getStyle(),16));
 		}
 		if (e.getSource() == b18) {
 			dat.setFont(new Font(dat.getFont().getName(),dat.getFont().getStyle(),18));
 		}
 		if (e.getSource() == b20) {
 			dat.setFont(new Font(dat.getFont().getName(),dat.getFont().getStyle(),20));
 		}
 		if (e.getSource() == b22) {
 			dat.setFont(new Font(dat.getFont().getName(),dat.getFont().getStyle(),22));
 		}
 		
 		if (e.getSource() == about) {
 			JOptionPane.showMessageDialog(null, "Written by Anh Vuong - Troy University - Spring 2016", "", JOptionPane.INFORMATION_MESSAGE);
 		}
 		if (e.getSource() == by) {
 			dat.setBackground(Color.yellow);
 		}
 		if (e.getSource() == bc) {
 			dat.setBackground(Color.cyan);
 		}
 		if (e.getSource() == bgr) {
 			dat.setBackground(Color.green);
 		}
 		if (e.getSource() == fb) {
 			dat.setForeground(Color.black);
 		}
 		if (e.getSource() == fr) {
 			dat.setForeground(Color.red);
 		}
 		if (e.getSource() == fbl) {
 			dat.setForeground(Color.blue);
 		}
 	}
 	public static void main (String args[]) {
 		new notepad().setVisible(true);
 	}
 }
