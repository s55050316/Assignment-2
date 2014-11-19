import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;



public class browser extends javax.swing.JFrame {
    public browser() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GET = new javax.swing.JButton();
        input = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        display = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        display1 = new javax.swing.JEditorPane();
        input1 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        text1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tanatat Kachanuban  s55050316@kmitl.ac.th - Java Web Browser (Network Programming Class Assignment)");

        GET.setText("GET");
        GET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GETActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(display);

        jScrollPane2.setViewportView(display1);

        text.setColumns(20);
        text.setRows(5);
        jScrollPane5.setViewportView(text);

        text1.setColumns(20);
        text1.setRows(5);
        jScrollPane6.setViewportView(text1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GET, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                            .addComponent(jScrollPane6))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GET)
                    .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GETActionPerformed
        String address=this.input.getText();
        String address1=this.input1.getText();
        for(int i=1; i<2; i++){
            new Thread("" + i){
        public void run()
        {   
          text.append("Thread : " + getName() + " Get URL Page = " + address + "\n");
        }
        }.start();
        }
        
        text1.append("Thread : 1 HEADER RESPONSE . . .  \n " );
        
        try{
         this.display.setPage(address);
         this.display1.setPage(address1);
         }
        catch(Exception e){}
        
        try {
            
	URL obj = new URL(address);
	URLConnection conn = obj.openConnection();
	    Map<String, List<String>> map = conn.getHeaderFields();

	for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            text1.append(" . . . \n" );
            text1.append("" + entry.getKey() + " ,Value : " + entry.getValue() );

		System.out.println("" + entry.getKey() 
                           + " ,Value : " + entry.getValue());
	}
        for(int i=1; i<2; i++){
            new Thread("" + i){
        public void run()
        {   
          text.append("Thread : " + getName() + " running \n ");
        }
        }.start();
        }
        text1.append("\n . . ." );
	String server = conn.getHeaderField("Server");
 
	if (server == null) {
		System.out.println("Server is not found!");
	} else {
		System.out.println("Server - " + server);
	}
        
        } catch (Exception e) {
	e.printStackTrace();
        }
        
        /////////////////////Text 2 //////////////////////////////
        
        for(int i=1; i<2; i++){
            new Thread("" + (i+1)){
        public void run()
        {   
          text.append("Thread : " + getName() + " Get URL Page = " + address1 + "\n");
        }
        }.start();
        }
        try {
            for(int i=1; i<2; i++){
            new Thread("" + (i+1)){
            public void run()
        {   
          text.append("Thread : " + getName() + " running \n ");
        }
         }.start();
        }
            text1.append("\n Thread : 2 HEADER RESPONSE . . .  \n " );
            URL obj = new URL(address1);
            URLConnection conn = obj.openConnection();
	    Map<String, List<String>> map = conn.getHeaderFields();
        
	for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            text1.append(" . . . \n" );
            text1.append("" + entry.getKey() + " ,Value : " + entry.getValue() );

		System.out.println("" + entry.getKey() 
                           + " ,Value : " + entry.getValue());
	}
        text1.append("\n . . ." );
	String server = conn.getHeaderField("Server");
 
	if (server == null) {
		System.out.println("Server is not found!");
	} else {
		System.out.println("Server - " + server);
	}
 
	for(int i=1; i<3; i++){
            new Thread("" + i){
        public void run()
        {   
          text.append("Thread : " + getName() + " Terminated \n ");
        }
        }.start();
        }
        text1.append("\n Thread : 1 TERMINATED " );
        text1.append("\n Thread : 2 TERMINATED " );       
        } catch (Exception e) {
	e.printStackTrace();
    }
    }//GEN-LAST:event_GETActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new browser().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GET;
    private javax.swing.JEditorPane display;
    private javax.swing.JEditorPane display1;
    private javax.swing.JTextField input;
    private javax.swing.JTextField input1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea text;
    private javax.swing.JTextArea text1;
    // End of variables declaration//GEN-END:variables
}
