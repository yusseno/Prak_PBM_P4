package utdi.yusseno.prak_pbm_p4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import utdi.yusseno.prak_pbm_p4.ui.theme.Prak_PBM_P4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Prak_PBM_P4Theme {
                // Menetapkan tema aplikasi menggunakan Prak_PBM_P4Theme
                // Menggunakan Surface sebagai latar belakang dengan warna background tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Page() // Memanggil fungsi Page() untuk menampilkan konten aplikasi
                }
            }
        }
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        // Membuat teks yang menggunakan AnnotatedString dengan beberapa gaya teks berbeda
        val text: AnnotatedString = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Blue)) {
                append("Description")
            }
            withStyle(style = SpanStyle(fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)) {
                append(" of ")
            }
            withStyle(style = SpanStyle(fontWeight = androidx.compose.ui.text.font.FontWeight.Bold, color = Color.Blue)) {
                append("IK")
            }
        }

        // Menampilkan teks dengan gaya yang sudah ditentukan
        Text(
            text = text,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp) // Menambahkan padding di atas dan di bawah teks
        )

        // Menampilkan gambar menggunakan Image composable dengan ukuran 140 dp
        Image(
            painter = painterResource(R.drawable.logo_ukmik),
            contentDescription = "location icon",
            modifier = Modifier.size(140.dp)
        )

        // Menampilkan teks dengan gaya headlineSmall dan memberikan padding di atas dan di bawah teks
        Text(
            text = "Unit Kegiatan Mahasiswa",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Informatika dan Komputer",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

@Composable
fun Content(modifier: Modifier = Modifier){
    // Menampilkan teks dalam kotak dengan warna latar belakang dan bentuk yang sudah ditentukan
    Surface(
        color = Color(0xff87cefa), // Warna latar belakang kotak
        shape = MaterialTheme.shapes.small // Bentuk (shape) kotak
    ) {
        // Kotak dengan padding dan teks yang diatur ke dalamnya dengan warna teks hitam dan alignment justify
        Box(
            modifier = Modifier
                .padding(16.dp), // Padding (jarak) antara teks dan batas kotak
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "UKM Informatika dan Komputer di UTDI (Universitas Teknologi Digital Indonesia), yang sebelumnya dikenal sebagai STMIK Akakom Yogyakarta, berdiri pada tanggal 12 April 1995. Tujuan utamanya adalah mendorong pengembangan keilmuan dan penalaran ilmiah, mengaktifkan kreativitas dan inovasi di kalangan pengurus dan anggota, serta melaksanakan kegiatan sosial yang memberikan manfaat kepada masyarakat. Dengan fokus pada pengembangan ilmu dan kontribusi sosial, UKM Informatika dan Komputer di UTDI menjadi wadah yang berharga untuk pengembangan pengetahuan dan pelayanan masyarakat.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Justify,
                color = Color.Black // Warna teks di dalam kotak
            )
        }
    }
}

@Composable
fun Page(){
    // Menggunakan Column untuk menampilkan konten secara vertikal
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp) // Memberikan padding pada semua sisi konten
    ) {
        Header() // Memanggil fungsi Header() untuk menampilkan header aplikasi

        Spacer(modifier = Modifier.width(16.dp)) // Memberikan spasi horizontal sebesar 16 dp

        Content() // Memanggil fungsi Content() untuk menampilkan konten utama aplikasi
    }
}

@Preview(showBackground = true)
@Composable
fun PagePreview(){
    Prak_PBM_P4Theme {
        Page() // Menampilkan preview konten aplikasi menggunakan Prak_PBM_P4Theme
    }
}
