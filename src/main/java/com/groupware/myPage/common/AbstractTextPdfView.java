package com.groupware.myPage.common;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public abstract class AbstractTextPdfView extends AbstractView {

   public AbstractTextPdfView() {
      setContentType("application/pdf");
   }

   @Override
   protected final void renderMergedOutputModel(Map<String, Object> model,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception {
      ByteArrayOutputStream baos = createTemporaryOutputStream();
      Document document = newDocument();
      PdfWriter writer = newWriter(document, baos);
      prepareWriter(model, writer, request);
      buildPdfMetadata(model, document, request);

      document.open();
      buildPdfDocument(model, document, writer, request, response);
      writeToResponse(response, baos);
   }

   @Override
   protected void writeToResponse(HttpServletResponse response,
         ByteArrayOutputStream baos) throws IOException {
      response.setContentType(getContentType());
      ServletOutputStream out = response.getOutputStream();
      baos.writeTo(out);
      out.flush();
   }
   
   protected Document newDocument() {
      return new Document(PageSize.A4);
   }

   protected PdfWriter newWriter(Document document, ByteArrayOutputStream os)throws DocumentException {
      return PdfWriter.getInstance(document, os);
   }
   
   protected void prepareWriter(Map<String, Object> model, PdfWriter writer,
         HttpServletRequest request) {
      writer.setViewerPreferences(getViewerPreferences());

   }


   protected int getViewerPreferences() {
      return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
   }
   
   protected abstract void buildPdfMetadata(Map<String, Object> model, Document document,
         HttpServletRequest request);

   protected abstract void buildPdfDocument(Map<String, Object> model, Document document,
         PdfWriter writer, HttpServletRequest request,
         HttpServletResponse response)throws Exception;



}