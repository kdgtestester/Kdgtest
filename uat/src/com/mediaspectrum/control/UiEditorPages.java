package com.mediaspectrum.control;


import com.mediaspectrum.pages.booking.uieditor.ContractPage;
import com.mediaspectrum.pages.booking.uieditor.FilesPage;
import com.mediaspectrum.pages.booking.uieditor.MediaCriteriaPage;
import com.mediaspectrum.pages.booking.uieditor.OnlineContentPage;

public class UiEditorPages {

    private static UiEditorPages uiEditorPages;

    private ContractPage contractPage;
    private FilesPage filesPage;
    private MediaCriteriaPage mediaCriteriaPage;
    private OnlineContentPage onlineContentPage;

    private UiEditorPages() {
        contractPage = new ContractPage();
        filesPage = new FilesPage();
        mediaCriteriaPage = new MediaCriteriaPage();
        onlineContentPage = new OnlineContentPage();
    }

    public static void setupPages(){ uiEditorPages = new UiEditorPages();}

    public static ContractPage contractPage() {return uiEditorPages.contractPage;}
    public static FilesPage filesPage() {return  uiEditorPages.filesPage;}
    public static MediaCriteriaPage mediaCriteriaPage() {return  uiEditorPages.mediaCriteriaPage;}
    public static OnlineContentPage onlineContentPage() {return  uiEditorPages.onlineContentPage;}

}
