package ordenadores;
import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;
public class Pcs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer= new Scanner(System.in);
		String tipo= new String();
		int presupuesto;
		String respuesta= new String();
		String tipopc= new String();
		System.out.println("¿Te interesa que sea portatil o ordenador de sobremesa?");
		tipopc=leer.next();
		String pobre ="No hay nada recomendable por ese presupuesto";
		
		
		if (tipopc.equals("sobremesa")) {
				
				
		System.out.println("¿Cual es tu presupuesto?\n\n");
				
			int sobremesa = leer.nextInt();
		
		if (sobremesa <=600) {
			System.out.println("Placa Base: Gigabyte B450M S2H \n"
					+ "GPU: Nvidia GeForce RTX 1650 \n"
					+ "CPU: AMD Ryzen 5 5600 \n"
					+ "RAM: Corsair Vengeance LPX 2400 16GB CL14\n"
					+ "Almacenamiento principal: Kingston A400 SSD 240GB\n"
					+ "Almacenamiento secundario: Seagate BarraCuda 3.5 1TB SATA3\n"
					+ "Chasis: Nfortec Lynx Cristal Templado USB 3.0 RGB\n"
					+ "Fuente de Alimentación: Tempest PSU 550W"
					+ "\n\n"
					+ "Precio aproximado: 600€.");
		}
		
		if (sobremesa >600 & sobremesa <=1200) {
			System.out.println("Placa Base: Asus TUF B550-PLUS WIFI II\n"
					+ "GPU: Nvidia GeForce RTX 3060\n"
					+ "CPU: AMD Ryzen 5 5600X \n"
					+ "RAM: Corsair Vengeance RGB 3200 16GB CL16\n"
					+ "Almacenamiento principal: Kioxia Excerioa G2 SSD 1TB NVMe M.2\n"
					+ "Refrigeración: Tempest Liquid Cooler 240 RGB \n"
					+ "Chasis: Tempest Umbra RGB Torre ATX\n"
					+ "Fuente de Alimentación: Seasonic Core GM-500 500W 80 Plus Gold"
					+ "\n\n"
					+ "Precio aproximado: 1200€. Si quiere recortar en gastos, sustituir la GPU por una RTX 2060.");	
		}
		
		if (sobremesa > 1200) {	
			System.out.println("Placa Base: Asus TUF B550-PLUS WIFI II\n"
					+ "GPU: Nvidia GeForce RTX 3080\n"
					+ "CPU: AMD Ryzen 7 5800X\n"
					+ "RAM: Corsair Vengeance 3200 32GB CL16\n"
					+ "Almacenamiento principal: Samsung 980 PRO 2TB\n"
					+ "Refrigeración: Lian Li Galahad AIO 360\n"
					+ "Ventiladores extra: Lian-Li Uni Fan SL 120 (x3)"
					+ "Chasis: Lian Li PC-O11 Dynamic\n"
					+ "Fuente de Alimentación: Corsair RM850 Plus Gold"
					+ "\n\n"
					+ ""
					+ "Precio aproximado: 2400€. Si quiere recortar en gastos, sustituir la GPU por una RTX 3070.");
		}
		
	}
		if(tipopc.equals("portatil")) {
			System.out.println("¿de que presupuesto dispones?");
			presupuesto=leer.nextInt();
			System.out.println("¿Te interesa que no haga nada de ruido (a costa del rendimiento)?");
			String silencio = leer.next();
			if (silencio.equals("si")) {
				
				System.out.println("¿Quieres Windows sí o sí o no te importa MacOS o ChromeOS?");
				String sistema = leer.next();
				if (sistema.equals("no") & presupuesto >= 600) {
					
					System.out.println("Macbook Air M1 (900€)");
					
				}
				
				if (sistema.equals("si") & presupuesto >= 600) {
					
					System.out.println("Microsoft Surface Pro X (600€)");
					
				}
				
				if (sistema.equals("no") & presupuesto < 600 & presupuesto >= 300) {
					
					System.out.println("Chromebook Flip C434 (400€, Chrome OS)");
					
				}
				
				if (sistema.equals("si") & presupuesto < 600 & presupuesto >= 300) {
					
					System.out.println("Asus VivoBook Go 14 L410 (350€)");
					
				}
				
				if (presupuesto <300) {
					
				 System.out.println(pobre);
					
				}
				
			}
				
			if (silencio.equals("no")) {
				
			System.out.println("¿lo quieres enfocado a trabajar, jugar o multimedia?");
			tipo=leer.next();
			if (tipo.equals("trabajar")) {
				if(presupuesto>1482) {
				respuesta+="● Dell XPS 13 9315 Intel Core i7-1250U/16GB/512GB SSD/13.4 (1482€) \"\r\n"
						+ "Procesador: Intel Core i7-1250U (10 núcleos, frecuencia hasta 4.7?GHz, 12 MB caché)\r\n"
						+ "Memoria RAM: 16 GB de RAM DDR5 5200MHz\r\n"
						+ "Almacenamiento: 512 GB SSD M.2 NVMe PCIe\r\n"
						+ "Unidad óptica: No dispone\r\n"
						+ "Display WVA LED de 13.4\" 500 nits de Brillo y sRGB 100% Resolución FHD+ (1920 x\r\n"
						+ "1200px)\r\n"
						+ "Controlador gráfico: Integrada Intel Iris Xe\r\n"
						+ "Conectividad: Intel Wi-Fi 6E (11ax, 2x2) / Bluetooth 5.2\r\n"
						+ "Webcam: HD\r\n"
						+ "Micrófono: Sí\r\n"
						+ "Audio: Altavoces Stereo (2x 2W)\r\n"
						+ "Batería: Polímero de Litio de 51 Wh, 3 Celdas\r\n"
						+ "Teclado retroiluminado: Sí\r\n"
						+ "Sistema operativo: Windows 11 Pro 64 bits\r\n"
						+ "Dimensiones (Ancho x Profundidad x Altura): 295 x 200 x 14 mm\r\n"
						+ "Peso 1,17 kg\r\n"
						+ "\r\n"
						+ "Color Plata";
				}
				if(presupuesto<1482 & presupuesto>699) {
				respuesta+="HP 15S-FQ5013NS Intel Core i5-1235U/8GB/512GB SSD/15.6 (699€) \"\r\n"
						+ "Procesador Intel® CoreTM i5-1235U (hasta 4,4 GHz con tecnología Intel® Turbo Boost, 12\r\n"
						+ "MB de caché L3, 10 núcleos, 12 subprocesos)\r\n"
						+ "Memoria RAM 8 GB RAM DDR4-3200 MHz (2 x 4 GB)\r\n"
						+ "Almacenamiento\r\n"
						+ "512 GB SSD PCIe® NVMeTM M.2\r\n"
						+ "Sistema operativo: Windows 11 Home\r\n"
						+ "Dimensiones: (Ancho x Profundidad x Altura): 35,85 x 24,2 x 1,79 cm\r\n"
						+ "Peso: 1,69 kg\r\n"
						+ "Color: Plata natural\r\n"
						+ "Pantalla: 15,6\" (39,6 cm) en diagonal, bisel micro-edge, antirreflectante, 250 nits, 45 %\r\n"
						+ "NTSC, Full HD (1920 x 1080)\r\n"
						+ "Controlador gráfico Integrado: Gráficos Intel® Iris® Xe\r\n"
						+ "Conectividad Combo Realtek RTL8822CE 802.11a/b/g/n/ac (2x2) Wi-Fi® y Bluetooth® 5\r\n"
						+ "Webcam HP True Vision 720p HD con reducción de ruido temporal y micrófonos digitales de\r\n"
						+ "matriz dual integrados\r\n"
						+ "Audio Altavoces dobles\r\n"
						+ "Teclado Tamaño completo de color plata natural y con teclado numérico\r\n"
						+ "Touchpad HP Imagepad compatible con función gestual multitáctil; Compatible con panel\r\n"
						+ "táctil de precisión\r\n"
						+ "Batería Ion-litio de 3 celdas 41 Wh";
				}
				if(presupuesto<699 & presupuesto>199) {
					respuesta+="Dell Latitude E5450 14\" Core i5 2,3 GHz - HDD 480 GB - 8GB (199€)\r\n"
						+ "Color: Negro\r\n"
						+ "Tamaño pantalla (pulgadas) : 14\r\n"
						+ "Almacenamiento: 480 GB HDD\r\n"
						+ "Memoria RAM: 8 GB\r\n"
						+ "Modelo: Latitude E5450\r\n"
						+ "Procesador: Core i5-5300U\r\n"
						+ "Velocidad del procesador: 2,3 GHz\r\n"
						+ "Marca del procesador: Intel\r\n"
						+ "Tarjeta gráfica: Intel HD Graphics 5500\r\n"
						+ "Sistema operativo: Windows 10\r\n"
						+ "Resolución: 1920 x 1080\r\n"
						+ "Wi-Fi: Sí\r\n"
						+ "Ethernet: Sí\r\n"
						+ "\r\n"
						+ "Año de lanzamiento: 2015\r\n"
						+ "Tipo de teclado e idioma: QWERTY - Español\r\n"
						+ "Pantalla táctil: No\r\n"
						+ "Bluetooth: No\r\n"
						+ "Webcam: Sí\r\n"
						+ "Micrófono: Sí\r\n"
						+ "Marca: Dell\r\n"
						+ "Peso: 1968 g;";
				}
				if(presupuesto<199) {
				respuesta+=pobre;
				}
			}
			if (tipo.equals("jugar")) {
				if(presupuesto>2500) {
				respuesta+="ASUS ROG Zephyrus G15 GA503QS-HQ004T (2500€)\r\n"
						+ "15.6”\r\n"
						+ "IPS\r\n"
						+ "1440p\r\n"
						+ "165Hz\r\n"
						+ "RTX 3080";
				}
				if(presupuesto>1169 & presupuesto<2500) {
				respuesta+="Lenovo Luego n 5 Gen 6  (1169€)\r\n"
						+ "15.6\"\r\n"
						+ "IPS\r\n"
						+ "1440\r\n"
						+ "165Hz\r\n"
						+ "RTX 3070;";
				}
				if(presupuesto>849 & presupuesto<1169) {
				respuesta+="KD-52ES123SD (849€)\r\n"
						+ "15.6\"\r\n"
						+ "IPS\r\n"
						+ "1080\r\n"
						+ "144Hz\r\n"
						+ "RTX 3060";
				}
				if(presupuesto>779 & presupuesto<849) {
				respuesta+="Acer Nitro 5 AN515-58 (779€)\r\n"
						+ "15.6\"\r\n"
						+ "IPS\r\n"
						+ "1080\r\n"
						+ "144Hz\r\n"
						+ "RTX 3050\r\n"
						+ "Medio-Alto: Gigabyte G5";
				}
				if(presupuesto>649 & presupuesto<779) {
				respuesta+="ASUS TUF Gaming F15 FX506LHB-HN324 (649€)\r\n"
						+ "(649€)\r\n"
						+ "15.6\r\n"
						+ "IPS\r\n"
						+ "1080\r\n"
						+ "144Hz\r\n"
						+ "RTX 1650";
				}
				if(presupuesto<649) {
				respuesta+=pobre;
				}
			}
			if (tipo.equals("multimedia")) {
				if(presupuesto>1500) {
				respuesta+="Asus vivobook pro 16 x oled (1500€)"
						+"Pantalla de 16\" WQUXGA 3840 x 2400 pixeles OLED 400 nits\r\n"
						+ "Procesador AMD Ryzen 7 5800H (8C/OctaCore 3.2 / 4.4GHz, 16MB)\r\n"
						+ "Memoria RAM de 16GB SO-DIMM DDR4\r\n"
						+ "Almacenamiento de 1TB SSD M.2 NVMe PCIe\r\n"
						+ "Tarjeta gráfica NVIDIA GeForce RTX 3050 4GB GDDR6\r\n"
						+ "Sistema Operativo: Windows 10 Home";
				}
				if(presupuesto>642 & presupuesto<1500) {
				respuesta+="Lenovo IdeaPad 3 (642€)"
						+"Pantalla de 15.6\" FullHD 1920x1080 píxeles, IPS, 250nits, Anti-glare\r\n"
						+ "Procesador AMD Ryzen 7 3700U (4C / 8T, 2.3 / 4.0GHz, 2MB L2 / 4MB L3)\r\n"
						+ "Memoria RAM de 8GB (4GB Soldered DDR4-2400 + 4GB SO-DIMM DDR4-2400)\r\n"
						+ "Almacenamiento de 512GB SSD M.2 2280 PCIe 3.0x4 NVMe\r\n"
						+ "Tarjeta gráfica Integrada AMD Radeon RX Vega 10 Graphics\r\n"
						+ "Sistema operativo: Windows 10 Home";
				}
				if(presupuesto>299 & presupuesto<642) {
				respuesta+="Asus E410MA (299€)"
						+"Procesador Intel® Celeron® N4020 (2 Núcleos, 2 Subprocesos, Caché: 4MB, 1.10GHz hasta 2.80GHz, 64-bit)\r\n"
						+ "Memoria RAM 4GB (4GB [EN PLACA]) DDR4 2400MHz\r\n"
						+ "Almacenamiento 64GB EMMC\r\n"
						+ "Unidad óptica No\r\n"
						+ "Display 14\" (35,56cm) LED Retroiluminado / 60Hz / NanoEdge (Borde Estrecho) / 200nits / FHD (1920x1080/16:9) / Antirreflejos / NTSC:45%\r\n"
						+ "Controlador gráfico Intel® UHD Graphics 600\r\n"
						+ "Conectividad\r\n"
						+ "Wi-Fi 5 (802.11ac) 1x1\r\n"
						+ "Bluetooth® 4.1\r\n"
						+ "Cámara de portátil VGA (640x480)\r\n"
						+ "Batería 42Wh, 3 Celdas, Ion de Litio\r\n"
						+ "Sistema operativo Windows® 10 Home S (64Bits)\r\n"
						+ "Dimensiones (Ancho x Profundidad x Altura) 325 x 217 x 18~18,4 mm\r\n"
						+ "Peso 1,3 Kg (con batería de 3 celdas)\r\n"
						+ "Color Azul Eléctrico";
				}
				if(presupuesto<299) {
				respuesta+=pobre;
				}
			}
			System.out.println(respuesta);
			}
		}
	}
}
