/**
 * 
 */
package in.gov.uidai.auth.sampleapp;

import java.awt.Desktop;
import java.awt.Panel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.fop.pdf.PDFPage;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import in.cdac.esign_v1.Esign;
import in.gov.uidai.auth.sampleapp.Customer.UserBuilder;

/**
 * @author Sonal
 *
 */
public class GenerateBankForm extends JFrame{

	private String authXML = "";



	public GenerateBankForm(String authXML) {
		this.authXML  = authXML;
	}

	public void generateForm(Customer customer) {
		Document document = new Document();

		try {
			Font fontbold = FontFactory.getFont("Times-Roman", 25, Font.BOLD);
			String aadharId = customer.getAadharId();
			PdfWriter.getInstance(document, new FileOutputStream(aadharId + ".pdf"));
			document.open();

			// sections
			PdfPTable pageTable = new PdfPTable(3);
			pageTable.setWidthPercentage(100);
	        
			//String imageFileName = "E://aadhar-logo.png";
			// Section 0: header for the bank
			PdfPTable headerTable = new PdfPTable(3);
			headerTable.setWidthPercentage(100);
			// Image bankLogo = Image.getInstance(new
			// URL("file://E:/aadhar-logo.png"));
			Image image = Image.getInstance("E:\\logo.png");
			
			PdfPCell headerCellBankImage = new PdfPCell(image, true);
			//PdfPCell headerCellBankImage = new PdfPCell(new Paragraph(""));
			PdfPCell headerDetail = new PdfPCell(new Paragraph("Digitally Signed Account Creation Form", fontbold));
			PdfPCell headerCellBankDetail = new PdfPCell(new Paragraph("Mumbai"));
			// headerTable.addCell(headerCellBankImage);
			headerCellBankImage.setBorder(Rectangle.NO_BORDER);
			//headerCellBankImage.setFixedHeight(40);
		
			
			headerDetail.setBorder(Rectangle.NO_BORDER);
			headerDetail.setBorderColor(BaseColor.WHITE);
			headerDetail.setVerticalAlignment(Element.ALIGN_CENTER);
			headerCellBankDetail.setBorder(Rectangle.NO_BORDER);
			headerCellBankDetail.setBorderColor(BaseColor.WHITE);
			headerCellBankDetail.setVerticalAlignment(Element.ALIGN_BOTTOM);
			headerCellBankDetail.setHorizontalAlignment(Element.ALIGN_RIGHT);
			
			pageTable.addCell(headerCellBankImage);
			pageTable.addCell(headerDetail);
			pageTable.addCell(headerCellBankDetail);
			
			
			//empty row
			PdfPCell emptyRow = new PdfPCell(new Paragraph(""));
			emptyRow.setMinimumHeight(20);
			emptyRow.setColspan(3);
			emptyRow.setBorder(Rectangle.NO_BORDER);
			emptyRow.setBackgroundColor(BaseColor.WHITE);
			
			pageTable.addCell(emptyRow);

			// Section 1: Personal Information
			// Section 2: Image on right
			PdfPCell personalInformationSection = new PdfPCell(new Paragraph("Personal Information"));
			personalInformationSection.setColspan(3);
			
			pageTable.addCell(personalInformationSection);
			// Image customerImage = Image.getInstance(customerImageLoc);
			
			PdfPCell nameLabelCell = new PdfPCell(new Paragraph("Name:"));
			PdfPCell nameValueCell = new PdfPCell(new Paragraph(customer.getName()));
			nameLabelCell.setBorder(Rectangle.NO_BORDER);
			nameValueCell.setBorder(Rectangle.NO_BORDER);
			PdfPCell idLabelCell = new PdfPCell(new Paragraph("Id:"));
			PdfPCell idValueCell = new PdfPCell(new Paragraph(aadharId));
			idLabelCell.setBorder(Rectangle.NO_BORDER);
			idValueCell.setBorder(Rectangle.NO_BORDER);
			PdfPCell genderLabelCell = new PdfPCell(new Paragraph("Gender:"));
			PdfPCell genderValueCell = new PdfPCell(new Paragraph(customer.getGender()));
			genderLabelCell.setBorder(Rectangle.NO_BORDER);
			genderValueCell.setBorder(Rectangle.NO_BORDER);
			PdfPCell dobLabelCell = new PdfPCell(new Paragraph("DOB:"));
			PdfPCell dobValueCell = new PdfPCell(new Paragraph(customer.getDateOfBirth()));
			dobLabelCell.setBorder(Rectangle.NO_BORDER);
			dobValueCell.setBorder(Rectangle.NO_BORDER);
			PdfPCell phoneLabelCell = new PdfPCell(new Paragraph("Post Office Name:"));
			PdfPCell phoneValueCell = new PdfPCell(new Paragraph(customer.getPostOfficeName()));
			phoneLabelCell.setBorder(Rectangle.NO_BORDER);
			phoneValueCell.setBorder(Rectangle.NO_BORDER);
			PdfPCell emailLabelCell = new PdfPCell(new Paragraph("Email:"));
			PdfPCell emailValueCell = new PdfPCell(new Paragraph(customer.getEmail()));
			emailLabelCell.setBorder(Rectangle.NO_BORDER);
			emailValueCell.setBorder(Rectangle.NO_BORDER);
			PdfPCell customerImage = new PdfPCell(new Paragraph(""));
			customerImage.setBorder(Rectangle.BOX);
			customerImage.setMinimumHeight(40);
			customerImage.setRowspan(6);
			pageTable.addCell(idLabelCell);
			pageTable.addCell(idValueCell);
			pageTable.addCell(customerImage);
			pageTable.addCell(nameLabelCell);
			pageTable.addCell(nameValueCell);
			pageTable.addCell(genderLabelCell);
			pageTable.addCell(genderValueCell);
			pageTable.addCell(dobLabelCell);
			pageTable.addCell(dobValueCell);
			pageTable.addCell(phoneLabelCell);
			pageTable.addCell(phoneValueCell);
			pageTable.addCell(emailLabelCell);
			pageTable.addCell(emailValueCell);
			
			
			//personalInformationSection.addCell(piTable);
			// personalInformationSection.addCell(customerImage);
			PdfPCell emptyRow1 = new PdfPCell(new Paragraph(""));
			emptyRow1.setMinimumHeight(20);
			emptyRow1.setColspan(3);
			emptyRow1.setBorder(Rectangle.NO_BORDER);
			emptyRow1.setBackgroundColor(BaseColor.WHITE);
			
			pageTable.addCell(emptyRow1);
			// Section 3: Address Information
			PdfPCell addressInformationSection = new PdfPCell(new Paragraph("Address Information"));
			addressInformationSection.setColspan(3);
			pageTable.addCell(addressInformationSection);
			PdfPTable pafTable = new PdfPTable(2);
			PdfPCell landmarkLabelCell = new PdfPCell(new Paragraph("Landmark:"));
			PdfPCell landmarkValueCell = new PdfPCell(new Paragraph(customer.getLocality()));
			landmarkLabelCell.setBorder(Rectangle.NO_BORDER);
			landmarkValueCell.setBorder(Rectangle.NO_BORDER);
			landmarkValueCell.setColspan(2);
			PdfPCell buildingLabelCell = new PdfPCell(new Paragraph("Building:"));
			PdfPCell buildingValueCell = new PdfPCell(new Paragraph(customer.getBuilding()));
			buildingLabelCell.setBorder(Rectangle.NO_BORDER);
			buildingValueCell.setBorder(Rectangle.NO_BORDER);
			buildingValueCell.setColspan(2);
			PdfPCell streetLabelCell = new PdfPCell(new Paragraph("Street:"));
			PdfPCell streetValueCell = new PdfPCell(new Paragraph(customer.getStreet()));
			streetLabelCell.setBorder(Rectangle.NO_BORDER);
			streetValueCell.setBorder(Rectangle.NO_BORDER);
			streetValueCell.setColspan(2);
			PdfPCell cityLabelCell = new PdfPCell(new Paragraph("City:"));
			PdfPCell cityValueCell = new PdfPCell(new Paragraph(customer.getDistrict()));
			cityLabelCell.setBorder(Rectangle.NO_BORDER);
			cityValueCell.setBorder(Rectangle.NO_BORDER);
			cityValueCell.setColspan(2);
			PdfPCell stateLabelCell = new PdfPCell(new Paragraph("State:"));
			PdfPCell stateValueCell = new PdfPCell(new Paragraph(customer.getState()));
			stateLabelCell.setBorder(Rectangle.NO_BORDER);
			stateValueCell.setBorder(Rectangle.NO_BORDER);
			stateValueCell.setColspan(2);
			PdfPCell pincodeLabelCell = new PdfPCell(new Paragraph("pincode:"));
			PdfPCell pincodeValueCell = new PdfPCell(new Paragraph(customer.getPinCode()));
			pincodeLabelCell.setBorder(Rectangle.NO_BORDER);
			pincodeValueCell.setBorder(Rectangle.NO_BORDER);
			pincodeValueCell.setColspan(2);
			pageTable.addCell(landmarkLabelCell);
			pageTable.addCell(landmarkValueCell);
			pageTable.addCell(buildingLabelCell);
			pageTable.addCell(buildingValueCell);
			pageTable.addCell(streetLabelCell);
			pageTable.addCell(streetValueCell);
			pageTable.addCell(cityLabelCell);
			pageTable.addCell(cityValueCell);
			pageTable.addCell(stateLabelCell);
			pageTable.addCell(stateValueCell);
			pageTable.addCell(pincodeLabelCell);
			pageTable.addCell(pincodeValueCell);

			PdfPCell emptyRow4 = new PdfPCell(new Paragraph(""));
			emptyRow4.setMinimumHeight(20);
			emptyRow4.setColspan(3);
			emptyRow4.setBorder(Rectangle.NO_BORDER);
			emptyRow4.setBackgroundColor(BaseColor.WHITE);
			
			pageTable.addCell(emptyRow4);
			
			// Proof of Identity
			PdfPCell poiSection = new PdfPCell(new Paragraph("Proof Of Identity"));
			poiSection.setColspan(3);
			pageTable.addCell(poiSection);
			PdfPCell panNumberLabelCell = new PdfPCell(new Paragraph("Pan Number:"));
			PdfPCell panNumberValueCell = new PdfPCell(new Paragraph(customer.getPanNumber()));
			panNumberLabelCell.setBorder(Rectangle.NO_BORDER);
			panNumberValueCell.setBorder(Rectangle.NO_BORDER);
			panNumberValueCell.setColspan(2); 
			pageTable.addCell(panNumberLabelCell);
			pageTable.addCell(panNumberValueCell);
			
			/*PdfPCell emptyRow5 = new PdfPCell(new Paragraph(""));
			emptyRow5.setMinimumHeight(20);
			emptyRow5.setColspan(3);
			emptyRow5.setBorder(Rectangle.NO_BORDER);
			emptyRow5.setBackgroundColor(BaseColor.WHITE);
			
			pageTable.addCell(emptyRow5);
			
			// Proof of Identity
			PdfPCell poaSection = new PdfPCell(new Paragraph("Proof Of Address"));
			poaSection.setColspan(3);
			pageTable.addCell(poaSection);
			PdfPCell poaLabelCell = new PdfPCell(new Paragraph("Number:"));
			PdfPCell poaValueCell = new PdfPCell(new Paragraph(customer.getPanNumber()));
			poaLabelCell.setBorder(Rectangle.NO_BORDER);
			poaValueCell.setBorder(Rectangle.NO_BORDER);
			poaValueCell.setColspan(2);*/ 
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			PdfPCell emptyRow2 = new PdfPCell(new Paragraph(""));
			
			emptyRow2.setMinimumHeight(20);
			emptyRow2.setColspan(3);
			emptyRow2.setBorder(Rectangle.NO_BORDER);
			emptyRow2.setBackgroundColor(BaseColor.WHITE);
			
			pageTable.addCell(emptyRow2);
			
			
			
			
			// Section 4: Declaration
			PdfPCell declaration = new PdfPCell(new Paragraph(
					"I hereby declare, that all above mentioned facts are correct to my knowledge."));
			declaration.setColspan(3);
			declaration.setBorder(Rectangle.NO_BORDER);
			pageTable.addCell(declaration);
			
			
			document.add(pageTable);
			

			document.close();
			
			openFile(aadharId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void openFile(String aadharId) {
		File pdfFile = new File(aadharId+ ".pdf");
		if (pdfFile.exists()) {
			sendESignRequestForDocument(aadharId);
			if (Desktop.isDesktopSupported()) {
				try {
					Desktop.getDesktop().open(pdfFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("Awt Desktop is not supported!");
			}

		} else {
			System.out.println("File is not exists!");
		}

		
	}
	
	private void sendESignRequestForDocument(String aadharId) {
		
		File pdfFile = new File(aadharId+ ".pdf");
		if (pdfFile.exists()) {
			String documentHash;
			try {
				documentHash = DocumentHashing.documentHash(pdfFile);
				Esign esign =new Esign();
				esign.setInput(documentHash);
				esign.setAadhaar(!authXML.isEmpty()? authXML.getBytes() : aadharId.getBytes());
				jaxbObjectToXML(esign);
				
				JOptionPane.showMessageDialog(this,"Sending Esign Request: "+ esign);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
	}
	

	
	 private static void jaxbObjectToXML(Esign emp) {
		 
	        try {
	            JAXBContext context = JAXBContext.newInstance(Esign.class);
	            Marshaller m = context.createMarshaller();
	            //for pretty-print XML in JAXB
	            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	 
	            // Write to System.out for debugging
	             m.marshal(emp, System.out);
	 
	            // Write to File
//	            m.marshal(emp, new File(FILE_NAME));
	        } catch (JAXBException e) {
	            e.printStackTrace();
	        }
	    }
	
	/*private static void showFormInFrame(String aadharId) {
		//set up the frame and panel
		File pdfFile = new File(aadharId+ ".pdf");
		if (pdfFile.exists()) {
			JFrame frame = new JFrame("PDF Test");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        PagePanel panel = new Panel();
	        frame.add(panel);
	        frame.pack();
	        frame.setVisible(true);

	        //load a pdf from a byte buffer
	        File file = new File("Amityform.pdf");
	        RandomAccessFile raf = new RandomAccessFile(file, "r");
	        FileChannel channel = raf.getChannel();
	        ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,
	            0, channel.size());
	        PDFFile pdffile = new PDFFile(buf);

	        // show the first page
	        PDFPage page = pdffile.getPage(0);
	        panel.showPage(page);
		}
		else {
			System.out.println("No file");
		}
        
	}*/

/*	public static void main(String args[]) {

		Customer customer = new UserBuilder("amit").gender("Male").dob("1-Jan-15").phone("876543210").email("x@y.z")
				.building("ABC").locality("XYZ").district("Mumbai").panNumber("12345678").postOfficeName("ABC")
				.state("MH").street("AB")
				.build();
		generateForm(customer);
	}*/

}
