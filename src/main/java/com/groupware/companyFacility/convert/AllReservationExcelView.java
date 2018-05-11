package com.groupware.companyFacility.convert;

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
import com.groupware.dto.ReservationVO;

/**
 * @Class Name : AllReservationExcelView
 * @Description : AllReservationExcelView Excel
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
public class AllReservationExcelView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		response.setHeader("Content-Disposition", "attachment;filename=\"allReservationList.xls\";");
	      
	      HSSFSheet sheet = createFirstSheet(workbook); //페이지 정보(sheet) 설정
	      
	      createColumnLabel(sheet); //excel 문서의 컬럼명 세팅
		
	      List<ReservationVO> pageRanks = (List<ReservationVO>) model.get("allReservation"); //controller에서 setAtt한 거 가져옴.
	      int rowNum = 1;
	      for(ReservationVO rank : pageRanks){
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
			cell.setCellValue("예약코드"); //컬럼명
			
			cell = firstRow.createCell(1);
			cell.setCellValue("시설명");

			cell = firstRow.createCell(2);
			cell.setCellValue("예약날짜");
			
			cell = firstRow.createCell(3);
			cell.setCellValue("예약시간");
			
			cell = firstRow.createCell(4);
			cell.setCellValue("예약사원");
			
		}
	   
		private void createPageRankRow(HSSFSheet sheet, ReservationVO reserve, int rowNum) {
			
			HSSFRow row = sheet.createRow(rowNum); //행추가(행번호)
			HSSFCell cell = null;
			cell = row.createCell(0); //셀 삽입 (컬럼순번)
			cell.setCellValue(reserve.getReserv_code()); //값 할당(값)
			
			cell = row.createCell(1);
			cell.setCellValue(reserve.getMem_nm());
			
			cell = row.createCell(2);
			cell.setCellValue(reserve.getReserv_day());

			cell = row.createCell(3);
			cell.setCellValue(reserve.getReserv_time());
			
			cell = row.createCell(4);
			cell.setCellValue(reserve.getMem_nm());
			
		}

	}












