package com.groupware.memberManagement.convert;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.groupware.dto.MemberVO;

/**
 * @Class Name : SearchExcelView.java
 * @Description : searchmemberInfo Excel
 * @Modification Information
 * @author 김성수
 * @since 2016.08.29.
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.29.  김성수        최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
public class SearchExcelView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		response.setHeader("Content-Disposition", "attachment;filename=\"searchList.xls\";");
	      
	      HSSFSheet sheet = createFirstSheet(workbook); //페이지 정보(sheet) 설정
	      
	      createColumnLabel(sheet); //excel 문서의 컬럼명 세팅
		
	      List<MemberVO> pageRanks = (List<MemberVO>) model.get("memberList"); //controller에서 setAtt한 거 가져옴.
	      int rowNum = 1;
	      for(MemberVO rank : pageRanks){
	         createPageRankRow(sheet, rank, rowNum++); //excel 문서의 행추가
	      }
	   }

		private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
			HSSFSheet sheet = workbook.createSheet(); //sheet 생성
			workbook.setSheetName(0, "사원명단"); //(sheet 순번, sheet 제목)
			sheet.setColumnWidth(1, 256 * 40); //(컬럼번호, 크기) 1자/256
			return sheet;
		}

		   
		private void createColumnLabel(HSSFSheet sheet) {
			HSSFRow firstRow = sheet.createRow(0); //시작행 설정
			HSSFCell cell = null;
			
			cell = firstRow.createCell(0); //컬럼 순번
			cell.setCellValue("사원번호"); //컬럼명
			
			cell = firstRow.createCell(1);
			cell.setCellValue("사원명");

			cell = firstRow.createCell(2);
			cell.setCellValue("부서");
			
			cell = firstRow.createCell(3);
			cell.setCellValue("직책");
			
			cell = firstRow.createCell(4);
			cell.setCellValue("연락처");
			
			cell = firstRow.createCell(5);
			cell.setCellValue("이메일");
			
		}
	   
		private void createPageRankRow(HSSFSheet sheet, MemberVO member, int rowNum) {
			
			HSSFRow row = sheet.createRow(rowNum); //행추가(행번호)
			HSSFCell cell = null;
			cell = row.createCell(0); //셀 삽입 (컬럼순번)
			cell.setCellValue(member.getMem_num()); //값 할당(값)
			
			cell = row.createCell(1);
			cell.setCellValue(member.getMem_nm());
			
			cell = row.createCell(2);
			cell.setCellValue(member.getDep_nm());

			cell = row.createCell(3);
			cell.setCellValue(member.getPos_nm());
			
			cell = row.createCell(4);
			cell.setCellValue(member.getMem_tel());
			
			cell = row.createCell(5);
			cell.setCellValue(member.getMem_em());
			
		}

	}












