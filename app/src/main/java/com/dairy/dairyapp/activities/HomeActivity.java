package com.dairy.dairyapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dairy.dairyapp.R;
import com.dairy.dairyapp.databinding.ActivityHomeBinding;
import com.dairy.dairyapp.fragment.AccountFragment;
import com.dairy.dairyapp.fragment.AddAccountFragment;
import com.dairy.dairyapp.fragment.AllAccountFragment;
import com.dairy.dairyapp.fragment.HomeFragment;
import com.dairy.dairyapp.fragment.ProfileFragment;
import com.dairy.dairyapp.fragment.databasemanage.ImportDataFragment;
import com.dairy.dairyapp.fragment.help.FaqFragment;
import com.dairy.dairyapp.fragment.help.HelpLineFragment;
import com.dairy.dairyapp.fragment.help.ServicesFragment;
import com.dairy.dairyapp.fragment.help.VersionFragment;
import com.dairy.dairyapp.fragment.rate.AdvanceRateFragment;
import com.dairy.dairyapp.fragment.rate.FlateRateFragment;
import com.dairy.dairyapp.fragment.rate.ImportRateFragment;
import com.dairy.dairyapp.fragment.report.ItemSaleReportFragment;
import com.dairy.dairyapp.fragment.report.PaymentReportFragment;
import com.dairy.dairyapp.fragment.report.PurchaseReportFragment;
import com.dairy.dairyapp.fragment.report.SaleReportFragment;
import com.dairy.dairyapp.fragment.report.StockReportFragment;
import com.dairy.dairyapp.fragment.report.UnioSaleReportFragment;
import com.dairy.dairyapp.fragment.setting.AnalyseFragment;
import com.dairy.dairyapp.fragment.setting.EditPassFragment;
import com.dairy.dairyapp.fragment.setting.EditSnfFragment;
import com.dairy.dairyapp.fragment.setting.EditUserNameFragment;
import com.dairy.dairyapp.fragment.setting.FormateDateFragment;
import com.dairy.dairyapp.fragment.setting.LanguageFragment;
import com.dairy.dairyapp.fragment.setting.WeigningFragment;
import com.dairy.dairyapp.fragment.task.BonusFragment;
import com.dairy.dairyapp.fragment.task.DeductionFragment;
import com.dairy.dairyapp.fragment.task.DispatchFragment;
import com.dairy.dairyapp.fragment.task.ItemPaymentFragment;
import com.dairy.dairyapp.fragment.task.ItemSaleFragment;
import com.dairy.dairyapp.fragment.task.MilkCollectionFragment;
import com.dairy.dairyapp.fragment.task.MilkSaleFragment;
import com.dairy.dairyapp.fragment.task.StockFragment;


public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    Fragment mFragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_home);
        init();
        binding.imageTop.setVisibility(View.VISIBLE);
        binding.textTop.setVisibility(View.GONE);
        switchFragment(new HomeFragment());

    }

    private void init() {
        click();

    }

    private void click() {
        binding.imgDrawer.setOnClickListener(v->{
            binding.myDrawerLayout.openDrawer(GravityCompat.START);
        });
        drawerItemClick();

    }

    private void drawerItemClick() {
        LinearLayout profileLn=binding.myDrawerLayout.findViewById(R.id.profileLn);
        LinearLayout homeLn=binding.myDrawerLayout.findViewById(R.id.homeLn);
//account
        LinearLayout accountLn=binding.myDrawerLayout.findViewById(R.id.accountLn);
        ImageView accountImagedown=binding.myDrawerLayout.findViewById(R.id.accountImagedown);
        ImageView accountImageUp=binding.myDrawerLayout.findViewById(R.id.accountImageUp);
        TextView allaccount=binding.myDrawerLayout.findViewById(R.id.allaccount);
        TextView addaccount=binding.myDrawerLayout.findViewById(R.id.addaccount);
        TextView bankaccount=binding.myDrawerLayout.findViewById(R.id.bankaccount);

// task
        LinearLayout taskLn=binding.myDrawerLayout.findViewById(R.id.taskLn);
        ImageView taskImagedown=binding.myDrawerLayout.findViewById(R.id.taskImagedown);
        ImageView taskImageUp=binding.myDrawerLayout.findViewById(R.id.taskImageUp);
        TextView millcollection=binding.myDrawerLayout.findViewById(R.id.millcollection);
        TextView milksale=binding.myDrawerLayout.findViewById(R.id.milksale);
        TextView itemsale=binding.myDrawerLayout.findViewById(R.id.itemsale);
        TextView itempayment=binding.myDrawerLayout.findViewById(R.id.itempayment);
        TextView itemstock=binding.myDrawerLayout.findViewById(R.id.itemstock);
        TextView dispatch=binding.myDrawerLayout.findViewById(R.id.dispatch);
        TextView deduction=binding.myDrawerLayout.findViewById(R.id.deduction);
        TextView bonus=binding.myDrawerLayout.findViewById(R.id.bonus);

// report

        LinearLayout reportLn=binding.myDrawerLayout.findViewById(R.id.reportLn);
        ImageView reportImagedown=binding.myDrawerLayout.findViewById(R.id.reportImagedown);
        ImageView reportImageUp=binding.myDrawerLayout.findViewById(R.id.reportImageUp);
        TextView purchasereport=binding.myDrawerLayout.findViewById(R.id.purchasereport);
        TextView salereport=binding.myDrawerLayout.findViewById(R.id.salereport);
        TextView itemsalereport=binding.myDrawerLayout.findViewById(R.id.itemsalereport);
        TextView paymentreport=binding.myDrawerLayout.findViewById(R.id.paymentreport);
        TextView stockreport=binding.myDrawerLayout.findViewById(R.id.stockreport);
        TextView unionsalereport=binding.myDrawerLayout.findViewById(R.id.unionsalereport);


// rate


        LinearLayout rateLn=binding.myDrawerLayout.findViewById(R.id.rateLn);
        ImageView rateImagedown=binding.myDrawerLayout.findViewById(R.id.rateImagedown);
        ImageView rateImageUp=binding.myDrawerLayout.findViewById(R.id.rateImageUp);
        TextView importrate=binding.myDrawerLayout.findViewById(R.id.importrate);
        TextView flatrate=binding.myDrawerLayout.findViewById(R.id.flatrate);
        TextView advancerate=binding.myDrawerLayout.findViewById(R.id.advancerate);


// database management


        LinearLayout databaseLn=binding.myDrawerLayout.findViewById(R.id.databaseLn);
        ImageView databaseImagedown=binding.myDrawerLayout.findViewById(R.id.databaseImagedown);
        ImageView databaseImageUp=binding.myDrawerLayout.findViewById(R.id.databaseImageUp);
        TextView exportdata=binding.myDrawerLayout.findViewById(R.id.exportdata);
        TextView importdata=binding.myDrawerLayout.findViewById(R.id.importdata);

// help

        LinearLayout helpLn=binding.myDrawerLayout.findViewById(R.id.helpLn);
        ImageView helpImagedown=binding.myDrawerLayout.findViewById(R.id.helpImagedown);
        ImageView helpImageUp=binding.myDrawerLayout.findViewById(R.id.helpImageUp);
        TextView version=binding.myDrawerLayout.findViewById(R.id.version);
        TextView fax=binding.myDrawerLayout.findViewById(R.id.fax);
        TextView services=binding.myDrawerLayout.findViewById(R.id.services);
        TextView helplinenumber=binding.myDrawerLayout.findViewById(R.id.helplinenumber);

 // Setting

        LinearLayout settingLn=binding.myDrawerLayout.findViewById(R.id.settingLn);
        ImageView settingImagedown=binding.myDrawerLayout.findViewById(R.id.settingImagedown);
        ImageView settingImageUp=binding.myDrawerLayout.findViewById(R.id.settingImageUp);
        TextView language=binding.myDrawerLayout.findViewById(R.id.language);
        TextView analysedata=binding.myDrawerLayout.findViewById(R.id.analysedata);
        TextView weigning=binding.myDrawerLayout.findViewById(R.id.weigning);
        TextView editsnf=binding.myDrawerLayout.findViewById(R.id.editsnf);
        TextView formatdate=binding.myDrawerLayout.findViewById(R.id.formatdate);
        TextView editusername=binding.myDrawerLayout.findViewById(R.id.editusername);
        TextView editPass=binding.myDrawerLayout.findViewById(R.id.editPass);


        homeLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                switchFragment(new HomeFragment());
                binding.imageTop.setVisibility(View.VISIBLE);
            }
        });
        accountImagedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountImageUp.setVisibility(View.VISIBLE);
                accountImagedown.setVisibility(View.GONE);
                allaccount.setVisibility(View.VISIBLE);
                addaccount.setVisibility(View.VISIBLE);
                bankaccount.setVisibility(View.VISIBLE);
                accountLn.setBackgroundResource(R.color.colorBlue);
                allaccount.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new AccountFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.allaccount);
                });

                addaccount.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new AddAccountFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.bankaccount);
                });

                bankaccount.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new AllAccountFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.addaccount);
                });

            }
        });
        accountImageUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountImagedown.setVisibility(View.VISIBLE);
                accountImageUp.setVisibility(View.GONE);
                allaccount.setVisibility(View.GONE);
                addaccount.setVisibility(View.GONE);
                bankaccount.setVisibility(View.GONE);
                accountLn.setBackgroundResource(R.color.colorBlueLight);

            }
        });
        profileLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                switchFragment(new ProfileFragment());
                binding.imageTop.setVisibility(View.GONE);
                binding.textTop.setVisibility(View.GONE);


               // startActivity(new Intent(HomeActivity.this,ProfileActivity.class));
            }
        });
        taskImagedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskImageUp.setVisibility(View.VISIBLE);
                taskImagedown.setVisibility(View.GONE);
                millcollection.setVisibility(View.VISIBLE);
                milksale.setVisibility(View.VISIBLE);
                itemsale.setVisibility(View.VISIBLE);
                itempayment.setVisibility(View.VISIBLE);
                itemstock.setVisibility(View.VISIBLE);
                dispatch.setVisibility(View.VISIBLE);
                deduction.setVisibility(View.VISIBLE);
                bonus.setVisibility(View.VISIBLE);
                taskLn.setBackgroundResource(R.color.colorBlue);
                millcollection.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new MilkCollectionFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.milk_collection);
                });

                milksale.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new MilkSaleFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.milksale);
                });

                itemsale.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new ItemSaleFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.item_sal);
                });

                itempayment.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new ItemPaymentFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.payments);
                });


                itemstock.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new StockFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.stoke_update);
                });


                dispatch.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new DispatchFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.dispatch);
                });


                deduction.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new DeductionFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.deduction);
                });

                bonus.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new BonusFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.bonus);
                });
            }
        });
        taskImageUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskImagedown.setVisibility(View.VISIBLE);
                taskImageUp.setVisibility(View.GONE);
                millcollection.setVisibility(View.GONE);
                milksale.setVisibility(View.GONE);
                itemsale.setVisibility(View.GONE);
                itempayment.setVisibility(View.GONE);
                itemstock.setVisibility(View.GONE);
                dispatch.setVisibility(View.GONE);
                deduction.setVisibility(View.GONE);
                bonus.setVisibility(View.GONE);
                taskLn.setBackgroundResource(R.color.colorBlueLight);

            }
        });
        reportImagedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reportImageUp.setVisibility(View.VISIBLE);
                reportImagedown.setVisibility(View.GONE);
                purchasereport.setVisibility(View.VISIBLE);
                salereport.setVisibility(View.VISIBLE);
                itemsalereport.setVisibility(View.VISIBLE);
                paymentreport.setVisibility(View.VISIBLE);
                stockreport.setVisibility(View.VISIBLE);
                unionsalereport.setVisibility(View.VISIBLE);
                reportLn.setBackgroundResource(R.color.colorBlue);
                purchasereport.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new PurchaseReportFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.purchase_report);
                });

                salereport.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new SaleReportFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.sale_report);
                });

                itemsalereport.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new ItemSaleReportFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.item_sale_report);
                });

                paymentreport.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new PaymentReportFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.payment_report);
                });


                stockreport.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new StockReportFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.stock_report);
                });


                unionsalereport.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new UnioSaleReportFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.union_sale_report);
                });

            }
        });
        reportImageUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reportImagedown.setVisibility(View.VISIBLE);
                reportImageUp.setVisibility(View.GONE);
                purchasereport.setVisibility(View.GONE);
                salereport.setVisibility(View.GONE);
                itemsalereport.setVisibility(View.GONE);
                paymentreport.setVisibility(View.GONE);
                stockreport.setVisibility(View.GONE);
                unionsalereport.setVisibility(View.GONE);
                reportLn.setBackgroundResource(R.color.colorBlueLight);

            }
        });
        rateImagedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateImageUp.setVisibility(View.VISIBLE);
                rateImagedown.setVisibility(View.GONE);
                importrate.setVisibility(View.VISIBLE);
                flatrate.setVisibility(View.VISIBLE);
                advancerate.setVisibility(View.VISIBLE);
                rateLn.setBackgroundResource(R.color.colorBlue);
                importrate.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new ImportRateFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.import_rate);
                });

                flatrate.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new FlateRateFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.flat_rate);
                });

                advancerate.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new AdvanceRateFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.advanced_rate);
                });

            }
        });
        rateImageUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateImagedown.setVisibility(View.VISIBLE);
                rateImageUp.setVisibility(View.GONE);
                importrate.setVisibility(View.GONE);
                flatrate.setVisibility(View.GONE);
                advancerate.setVisibility(View.GONE);
                rateLn.setBackgroundResource(R.color.colorBlueLight);

            }
        });
        databaseImagedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseImageUp.setVisibility(View.VISIBLE);
                databaseImagedown.setVisibility(View.GONE);
                importdata.setVisibility(View.VISIBLE);
                exportdata.setVisibility(View.VISIBLE);
                databaseLn.setBackgroundResource(R.color.colorBlue);
                importdata.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new ImportDataFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.import_rate);
                });


            }
        });
        databaseImageUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseImagedown.setVisibility(View.VISIBLE);
                databaseImageUp.setVisibility(View.GONE);
                importdata.setVisibility(View.GONE);
                exportdata.setVisibility(View.GONE);
                databaseLn.setBackgroundResource(R.color.colorBlueLight);

            }
        });

        helpImagedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpImageUp.setVisibility(View.VISIBLE);
                helpImagedown.setVisibility(View.GONE);
                version.setVisibility(View.VISIBLE);
                fax.setVisibility(View.VISIBLE);
                services.setVisibility(View.VISIBLE);
                helplinenumber.setVisibility(View.VISIBLE);
                helpLn.setBackgroundResource(R.color.colorBlue);
                version.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new VersionFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText("Version");
                });


                fax.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new FaqFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText("FAQ");
                });


                services.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new ServicesFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText("Services");
                });


                helplinenumber.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new HelpLineFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText("Helpline Number");
                });


            }
        });
        helpImageUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpImagedown.setVisibility(View.VISIBLE);
                helpImageUp.setVisibility(View.GONE);
                version.setVisibility(View.GONE);
                fax.setVisibility(View.GONE);
                services.setVisibility(View.GONE);
                helplinenumber.setVisibility(View.GONE);
                helpLn.setBackgroundResource(R.color.colorBlueLight);

            }
        });



       settingImagedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingImageUp.setVisibility(View.VISIBLE);
                settingImagedown.setVisibility(View.GONE);
                language.setVisibility(View.VISIBLE);
                analysedata.setVisibility(View.VISIBLE);
                weigning.setVisibility(View.VISIBLE);
                editsnf.setVisibility(View.VISIBLE);
                formatdate.setVisibility(View.VISIBLE);
                editusername.setVisibility(View.VISIBLE);
                editPass.setVisibility(View.VISIBLE);
                settingLn.setBackgroundResource(R.color.colorBlue);
                language.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new LanguageFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.language);
                });


                analysedata.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new AnalyseFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.analyser_data);
                });


                weigning.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new WeigningFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.weighing_scale);
                });


                editsnf.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new EditSnfFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.edit_snf_formula);
                });


                formatdate.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new FormateDateFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.format_date_and_time);
                });


                editusername.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new EditUserNameFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.edit_username);
                });


                editPass.setOnClickListener(v1->{
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START);
                    switchFragment(new EditPassFragment());
                    binding.imageTop.setVisibility(View.GONE);
                    binding.textTop.setVisibility(View.VISIBLE);
                    binding.textTop.setText(R.string.edit_password);
                });


            }
        });
        settingImageUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingImagedown.setVisibility(View.VISIBLE);
                settingImageUp.setVisibility(View.GONE);
                language.setVisibility(View.GONE);
                analysedata.setVisibility(View.GONE);
                weigning.setVisibility(View.GONE);
                editsnf.setVisibility(View.GONE);
                formatdate.setVisibility(View.GONE);
                editusername.setVisibility(View.GONE);
                editPass.setVisibility(View.GONE);
                settingLn.setBackgroundResource(R.color.colorBlueLight);

            }
        });

    }

    private void switchFragment(Fragment mFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, mFragment).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {

    }
}