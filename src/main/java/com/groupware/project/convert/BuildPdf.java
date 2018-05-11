package com.groupware.project.convert;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.groupware.dto.MemberVO;
import com.groupware.dto.ProjectVO;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

/**
 * @Class Name : BuildPdf.java
 * @Description : 프로젝트 상세정보 PDF작성
 * @Modification Information
 * @author 정준호
 * @since 2016.09.01.
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *    	수정일            수정자                    수정내용
 *    -------      -------     -------------------
 *   2016.09.01.    정준호                    최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
public class BuildPdf extends AbstractPdfView{
	private String fontPath = "c:\\windows\\Fonts\\H2GTRM.ttf";

	/**
	 * PDF생성
	 * 
	 * @param (Model, Document, PdfWriter, Request, Response)
	 * @return void
	 * @throws Exception
	 */
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		ProjectVO pdfProject =  (ProjectVO) model.get("pdfProject");
		List<MemberVO> member = (List<MemberVO>) model.get("members");
		String members="";
		for(int i=0; i<member.size();i++){
			members+=member.get(i).getMem_nm();
			if(!(i==member.size()-1)){
				members+=", ";
			}
		}
		
		
		//BaseFont 설정
		BaseFont bfkorean = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		BaseFont bf = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		Font font = new Font(bfkorean);
		Font titlefont  = new Font(bf, 30, Font.BOLD);
		Font titlefont2  = new Font(bf, 20, Font.BOLD);
		Paragraph title = new Paragraph(pdfProject.getPro_nm(),titlefont);
		title.setAlignment(Element.ALIGN_CENTER);
		document.add(title);
		 
		 
		//Table생성
		Table table = new Table(2);
		table.setWidths(new int[]{30,80});
		table.setPadding(5);
		
		Cell cell = new Cell(new Paragraph("프로젝트 참여인원",font));
		cell.setHeader(true);
		table.addCell(cell);
		
		cell = new Cell(new Paragraph(members,font));
		table.addCell(cell);
		
		cell = new Cell(new Paragraph("프로젝트 시작일",font));
		table.addCell(cell);
		table.endHeaders();
		cell = new Cell(new Paragraph(pdfProject.getPro_beg_day(),font));
		table.addCell(cell);
		
		cell = new Cell(new Paragraph("프로젝트 종료일",font));
		table.addCell(cell);
		table.endHeaders();
		cell = new Cell(new Paragraph(pdfProject.getPro_end_day(),font));
		table.addCell(cell);
		
		document.add(table);
		
		
		Paragraph title2 = new Paragraph("프로젝트 상세내용",titlefont2);
		title2.setAlignment(Element.ALIGN_CENTER);
		document.add(title2);
		
		Table table2 = new Table(1);
		table2.setPadding(5);
		cell = new Cell(new Paragraph(pdfProject.getPro_dt_mm(),font));
		table2.addCell(cell);
		document.add(table2);
		
		//이미지 삽입
		 Image img = Image.getInstance("D://GDProject/spring_sts/workspace/GD/src/main/webapp/resources/assets/img/logo123.png");
		 img.scaleToFit(100, 100);
		 img.setAbsolutePosition(490, 10);
		 document.add(img);
		
	}
}
