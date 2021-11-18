package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.bo.ConsultaBO;
import model.bo.MedicoBO;
import model.vo.ConsultaVO;
import model.vo.MedicoVO;
import view.Telas;

public class TelaGerarRelatorioController extends Telas{
		
	@FXML TextField textoMedicoRelatorio;
	@FXML TextField textoDataInicio;
	@FXML TextField textoDataFim;
	@FXML ComboBox<String> medicos;
	
	public void voltar() {
		try {
			telaAdministrador();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void comboMedicos() {
		MedicoBO bo = new MedicoBO();
		List<MedicoVO> list = new ArrayList<>();
		try {
			list = bo.buscarTudo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> list2 = new ArrayList<>();
		for (MedicoVO vo : list) {
			list2.add(vo.getNome());
		}
		medicos.setItems(FXCollections.observableArrayList(list2));
	};
	
	public void gerarRelatorio() throws ParseException {
		
		
		
		
		Document document = new Document();
	      try {
	          PdfWriter.getInstance(document,
	          new FileOutputStream("RelatórioMédico.pdf"));
	          document.open();
	          
	  		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			ConsultaBO bo = new ConsultaBO();
		try {
			List<ConsultaVO> list = bo.buscarTudo();
			List<ConsultaVO> list2 = new ArrayList<>();
			String dataInicio = textoDataInicio.getText();
			String dataFim = textoDataFim.getText();
			Date firstDate = sdf.parse(dataInicio);
	        Date secondDate = sdf.parse(dataFim);
	        
	
	        Image img = Image.getInstance("LogoTopo.png");
	        document.add(img);
	        
	          Paragraph pConsulta = (new Paragraph("RELATÓRIO DE CONSULTAS"));
	          pConsulta.setAlignment(Element.ALIGN_CENTER);
	          document.add(pConsulta);
	          if(medicos.getValue() != null){
		          Paragraph medico = (new Paragraph(medicos.getValue()));
		          medico.setAlignment(Element.ALIGN_CENTER);
		          document.add(medico);
		          }
	          Paragraph datas = (new Paragraph("("+dataInicio +" - "+dataFim+")"));
	          datas.setAlignment(Element.ALIGN_CENTER);
	          document.add(datas);
	          Paragraph vazio = (new Paragraph("       "));
	          document.add(vazio);

			for(ConsultaVO vo: list) {
				Date data = sdf.parse(vo.getData());
				if(vo.getMedico().equals(medicos.getValue())) {
				if(data.getTime() >= firstDate.getTime() && data.getTime() <= secondDate.getTime()) {

		          Paragraph consultaId = (new Paragraph("ID: "+ vo.getId()));
		          document.add(consultaId);
		          Paragraph consultaPaciente = (new Paragraph("Paciente: "+ vo.getPaciente()));
		          document.add(consultaPaciente);
		          Paragraph consultaMedico = (new Paragraph("Médico: "+ vo.getMedico()));
		          document.add(consultaMedico);
		          Paragraph consultaData = (new Paragraph("Data: "+ vo.getData()));
		          document.add(consultaData);
		          Paragraph consultaHorario = (new Paragraph("Horario: "+ vo.getHorario()));
		          document.add(consultaHorario);
		          Paragraph consultaStatus = (new Paragraph("Status: "+ vo.getStatus()));
		          document.add(consultaStatus);
		          document.add(vazio);
					}
				 }
				if(medicos.getValue() == null || medicos.getValue().equals("")) {
					if(data.getTime() >= firstDate.getTime() && data.getTime() <= secondDate.getTime()) {

			          Paragraph consultaId = (new Paragraph("ID: "+ vo.getId()));
			          document.add(consultaId);
			          Paragraph consultaPaciente = (new Paragraph("Paciente: "+ vo.getPaciente()));
			          document.add(consultaPaciente);
			          Paragraph consultaMedico = (new Paragraph("Médico: "+ vo.getMedico()));
			          document.add(consultaMedico);
			          Paragraph consultaData = (new Paragraph("Data: "+ vo.getData()));
			          document.add(consultaData);
			          Paragraph consultaHorario = (new Paragraph("Horario: "+ vo.getHorario()));
			          document.add(consultaHorario);
			          Paragraph consultaStatus = (new Paragraph("Status: "+ vo.getStatus()));
			          document.add(consultaStatus);
			          document.add(vazio);
						}
					 }
				}
			}
	      catch(DocumentException de) {
	          System.err.println(de.getMessage());
	      }
	      catch(IOException ioe) {
	          System.err.println(ioe.getMessage());
	      }
	      document.close();

	  
	      } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

	}
}
	
