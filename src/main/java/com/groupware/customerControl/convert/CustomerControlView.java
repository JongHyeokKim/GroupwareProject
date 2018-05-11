package com.groupware.customerControl.convert;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.groupware.dto.AccountVO;

public class CustomerControlView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		response.setHeader("Content-Disposition","attachment; filename=\"customerList.xls\",");
		HSSFSheet sheet = createFirstSheet(workbook); //페이지 정보 설정. 
		createColumLabel(sheet); //excel문서의 컬럼명 세팅.
		
		List<AccountVO> pageRanks =(List<AccountVO>) model.get("customerList");
		int rowNum=1;
		for(AccountVO rank : pageRanks){
		createPageRankRow(sheet, rank, rowNum++);//excel 문서의 행추가
			 
		}
	}

	
	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet =workbook.createSheet();
		workbook.setSheetName(0,"거래처");	//(sheet순서, sheet 제목)
		sheet.setColumnWidth(1,256*40); //(컬럼번호,크기) 1자/256
		return sheet;
	}

	private void createColumLabel(HSSFSheet sheet) {
		HSSFRow firstRow = sheet.createRow(0); //시작행 설정
		HSSFCell cell =null;
		
		cell=firstRow.createCell(0); //컬럼순번
		cell.setCellValue("업체명"); //컬럼명
		
		cell=firstRow.createCell(1);
		cell.setCellValue("대표자");
		
		cell=firstRow.createCell(2);
		cell.setCellValue("거래처코드");
		
		cell=firstRow.createCell(3);
		cell.setCellValue("담당사원");
		
		cell=firstRow.createCell(4);
		cell.setCellValue("주소");
		
		cell=firstRow.createCell(5);
		cell.setCellValue("이메일");
		
		cell=firstRow.createCell(6);
		cell.setCellValue("전화번호");
	}

	private void createPageRankRow(HSSFSheet sheet, AccountVO rank, int rowNum) {
		
		HSSFRow row =sheet.createRow(rowNum);
		HSSFCell cell=null;
		
		cell=row.createCell(0);
		cell.setCellValue(rank.getAc_nm());
		
		cell=row.createCell(1);
		cell.setCellValue(rank.getAc_reps());
		
		cell=row.createCell(2);
		cell.setCellValue(rank.getAc_code());
		
		cell=row.createCell(3);
		cell.setCellValue(rank.getAc_mem_num());
		
		cell=row.createCell(4);
		cell.setCellValue(rank.getAc_addr());
		
		cell=row.createCell(5);
		cell.setCellValue(rank.getAc_em());
		
		cell=row.createCell(6);
		cell.setCellValue(rank.getAc_tel());
	}
}
