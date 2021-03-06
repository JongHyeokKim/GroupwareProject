package com.groupware.myPage.convert;


import java.io.FileInputStream;
import java.io.StringReader;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupware.dto.MemberVO;
import com.groupware.myPage.common.AbstractTextPdfView;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;


public class WorkPdf extends AbstractTextPdfView{
      @Override
       protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
               throws Exception {
    	  MemberVO memberVO = (MemberVO) model.get("memberVO");
    	  String work = (String) model.get("work");
    	  String requestDay = (String) model.get("request");
           String fontname = request.getSession().getServletContext().getRealPath("/resources/assets/fonts/GulimChe.ttf");
//           String filename = "d://filename.pdf";

           String replace = memberVO.getMem_jn();
           String joinDay = replace.replace("/", ".");
           String workReplace = work;
           String today = workReplace.replace("/", ".");
           today = today.substring(2,10); 
           String toYear = requestDay.substring(2,4);
           String toMonth = requestDay.substring(5,7);
           String toDay = requestDay.substring(8,10);
           
        // Document 생성
           document = new Document(PageSize.A4,50,50,20,20); // 용지 및 여백 설정
                
           // PdfWriter 생성
           writer = PdfWriter.getInstance(document, response.getOutputStream());
           writer.setInitialLeading(12.5f);
            
           // 파일 다운로드 설정
           response.setContentType("application/pdf");
//           String fileName = URLEncoder.encode("한글파일명", "UTF-8"); // 파일명이 한글일 땐 인코딩 필요
//           response.setHeader("Content-Transper-Encoding", "binary");
//           response.setHeader("Content-Disposition", "inline; filename=" + fileName + ".pdf");
            
           // Document 오픈
           document.open();
           XMLWorkerHelper helper = XMLWorkerHelper.getInstance();
                
           // CSS
           CSSResolver cssResolver = new StyleAttrCSSResolver();
           CssFile cssFile = helper.getCSS(new FileInputStream(request.getSession().getServletContext().getRealPath("/resources/assets/css/myPage.css")));
           cssResolver.addCss(cssFile);
           
           Image img = Image.getInstance(request.getSession().getServletContext().getRealPath("/resources/assets/img/logo123.png"));
           Image ownerImg = Image.getInstance(request.getSession().getServletContext().getRealPath("/resources/memberSign/$$1472705940772김성수인.png"));
           ownerImg.scaleToFit(50, 50);
           ownerImg.setAbsolutePosition(450, 110);
           document.add(ownerImg);
           img.scaleToFit(100, 100);
           img.setAbsolutePosition(490, 10);
           document.add(img);    
           // HTML, 폰트 설정
           XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
           fontProvider.register(fontname, "GulimChe"); // MalgunGothic은 alias,
           CssAppliers cssAppliers = new CssAppliersImpl(fontProvider);
            
           HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
           htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
            
           // Pipelines
           PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
           HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
           CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);
            
           XMLWorker worker = new XMLWorker(css, true);
           XMLParser xmlParser = new XMLParser(worker, Charset.forName("UTF-8"));
            
           // 폰트 설정에서 별칭으로 줬던 "MalgunGothic"을 html 안에 폰트로 지정한다.
           String htmlStr = "<html>"
                 + "<head>"
                 + "</head>"
                 + "<body style='font-family:GulimChe;'>"
                 + "<br/>"
                 + "<br/>"
                 + "<br/>"
                 + "<div style='font-size:50px; text-decoration:underline; text-align:center;'>재 직 증 명 서</div>"
                 + "<p style='font-size:40px;'><br/></p>" 
                 + "<table border='1' align='center' style='text-align:center; width:95%; font-size:20px;'>" 
                       + "<tr style='height:50px;'>" 
                       + "<td>문서번호</td>"
                       + "<td>GD-W-001</td>"
                       + "<td>직   급</td>"
                       + "<td>"+memberVO.getPos_nm()+"</td>"
                       + "</tr>"
                       + "<tr style='height:50px;'>"
                       + "<td>사원명</td>"
                       + "<td>"+memberVO.getMem_nm()+"</td>"
                       + "<td>주민등록번호</td>"
                       + "<td>"+memberVO.getMem_reg1()+"-"+memberVO.getMem_reg2()+"</td>"
                       + "</tr>"
                       + "<tr style='height:50px;'>"
                       + "<td>근무기간</td>"
                       + "<td colspan='3'>"+joinDay+"~"+today+"</td>"
                       + "</tr>"
                       + "<tr style='height:50px;'>"
                       + "<td>주    소</td>"
                       + "<td colspan='3'><pre>"+memberVO.getMem_addr()+" "+memberVO.getMem_dt_addr()+"</pre></td>"
                             + "</tr>"
                             + "<tr rowspan='10'>"
                                   + "<td colspan='4'>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "상기 근로자는 현재 당사에 재직하고 있음을 증명합니다."
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "<div align='center'>"+toYear+"<pre>년  </pre>"+toMonth+"<pre>월  </pre>"+toDay+"일</div>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "&nbsp;<br/>"
                                         + "<p align='right' style='margin-right:50px;'>"
                                               + "대표자　　(인)"
                                               + "</p>"
                                               + "&nbsp;<br/>"
                                               + "&nbsp;<br/>"
                                               + "&nbsp;<br/>"
                                               + "&nbsp;<br/>"
                                               + "</td>"
                                               + "</tr>"
                                               + "</table>"
                                               + "</body>"
                                               + "</html>";
            
           StringReader strReader = new StringReader(htmlStr);
           xmlParser.parse(strReader);
            
           document.close();
           writer.close();
           
       }
      

      /* private void setFileNameToResponse(HttpServletRequest request, HttpServletResponse response, String fileName) {
           String userAgent = request.getHeader("User-Agent");
           if (userAgent.indexOf("MSIE 5.5") >= 0) {
               response.setContentType("doesn/matter");
               response.setHeader("Content-Disposition", "filename=\"" + fileName + "\"");
           } else {
               response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
           }
       }

       private String createFileName() {
           SimpleDateFormat fileFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
           return new StringBuilder("pdf").append("-").append(fileFormat.format(new Date())).append(".pdf").toString();
       }*/

      @Override
      protected void buildPdfMetadata(Map<String, Object> model,
            Document document, HttpServletRequest request) {
         
      }

}