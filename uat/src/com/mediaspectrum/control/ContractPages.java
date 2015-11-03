package com.mediaspectrum.control;

import com.mediaspectrum.pages.contracts.ManageContractPage;
import com.mediaspectrum.pages.contracts.SearchContractPage;
import com.mediaspectrum.pages.contracts.SearchCreateContractPage;

/**
 * Created by kzavgorodniy on 05.05.2015.
 */
public class ContractPages {
    private static ContractPages contractPages;

    private SearchCreateContractPage searchCreateContractPage;
    private SearchContractPage searchContractPage;
    private ManageContractPage manageContractPage;

    private ContractPages() {
        searchCreateContractPage = new SearchCreateContractPage();
        searchContractPage = new SearchContractPage();
        manageContractPage = new ManageContractPage();
    }

    public static void setupPages() {contractPages = new ContractPages();}

    public static SearchCreateContractPage searchCreateContractPage(){return contractPages.searchCreateContractPage;}

    public static SearchContractPage searchContractPage() {return contractPages.searchContractPage;}

    public static ManageContractPage manageContractPage(){return contractPages.manageContractPage;}


}
