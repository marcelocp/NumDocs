package br.sc.gov.cge.numdocs.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.sc.gov.cge.numdocs.model.Ajuda;
import br.sc.gov.cge.numdocs.model.CA;
import br.sc.gov.cge.numdocs.model.CI;
import br.sc.gov.cge.numdocs.model.EM;
import br.sc.gov.cge.numdocs.model.InstrucaoNormativa;
import br.sc.gov.cge.numdocs.model.Informacao;
import br.sc.gov.cge.numdocs.model.OS;
import br.sc.gov.cge.numdocs.model.OT;
import br.sc.gov.cge.numdocs.model.Oficio;
import br.sc.gov.cge.numdocs.model.OficioCircular;
import br.sc.gov.cge.numdocs.model.Parecer;
import br.sc.gov.cge.numdocs.model.ParecerRCI;
import br.sc.gov.cge.numdocs.model.Portaria;
import br.sc.gov.cge.numdocs.model.PortariaConjunta;
import br.sc.gov.cge.numdocs.model.Programa;
import br.sc.gov.cge.numdocs.model.RCA;
import br.sc.gov.cge.numdocs.model.RelatorioAuditoria;
import br.sc.gov.cge.numdocs.model.RelatorioInspecao;
import br.sc.gov.cge.numdocs.model.RelatorioInvestigacao;
import br.sc.gov.cge.numdocs.repository.NumAjudaRepository;
import br.sc.gov.cge.numdocs.repository.NumCARepository;
import br.sc.gov.cge.numdocs.repository.NumCIRepository;
import br.sc.gov.cge.numdocs.repository.NumEMRepository;
import br.sc.gov.cge.numdocs.repository.NumINRepository;
import br.sc.gov.cge.numdocs.repository.NumInfoRepository;
import br.sc.gov.cge.numdocs.repository.NumOCRepository;
import br.sc.gov.cge.numdocs.repository.NumOSRepository;
import br.sc.gov.cge.numdocs.repository.NumOTRepository;
import br.sc.gov.cge.numdocs.repository.NumOficioRepository;
import br.sc.gov.cge.numdocs.repository.NumParecerRCIRepository;
import br.sc.gov.cge.numdocs.repository.NumParecerRepository;
import br.sc.gov.cge.numdocs.repository.NumPortariaConjuntaRepository;
import br.sc.gov.cge.numdocs.repository.NumPortariaRepository;
import br.sc.gov.cge.numdocs.repository.NumProgramaRepository;
import br.sc.gov.cge.numdocs.repository.NumRARepository;
import br.sc.gov.cge.numdocs.repository.NumRCARepository;
import br.sc.gov.cge.numdocs.repository.NumRelatorioInspecaoRepository;
import br.sc.gov.cge.numdocs.repository.NumRelatorioInvestigacaoRepository;

@RestController
@CrossOrigin(origins = "*")
public class NumDocsService {

	@Autowired
	private NumInfoRepository infoRepository;
	
	@Autowired
	private NumOSRepository osRepository;
	
	@Autowired
	private NumProgramaRepository programaRepository;
	
	@Autowired
	private NumOficioRepository oficioRepository;
	
	@Autowired
	private NumParecerRepository parecerRepository;
	
	@Autowired
	private NumCIRepository ciRepository;
	
	@Autowired
	private NumRARepository raRepository;
	
	@Autowired
	private NumAjudaRepository ajudaRepository;
	
	@Autowired
	private NumCARepository caRepository;
	
	@Autowired
	private NumEMRepository emRepository;
	
	@Autowired
	private NumINRepository inRepository;
	
	@Autowired
	private NumOCRepository ocRepository;
	
	@Autowired
	private NumOTRepository otRepository;
	
	@Autowired
	private NumParecerRCIRepository parecerRCIRepository;
	
	@Autowired
	private NumPortariaRepository portariaRepository;
	
	@Autowired
	private NumPortariaConjuntaRepository portariaConjuntaRepository;
	
	@Autowired
	private NumRCARepository rcaRepository;
	
	@Autowired
	private NumRelatorioInspecaoRepository rinspecaoRepository;
	
	@Autowired
	private NumRelatorioInvestigacaoRepository rinvestigacaoRepository;
	
	private DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	@PostMapping("/info")
	@ResponseStatus(HttpStatus.CREATED)
	public Informacao criarNumInfo(@RequestBody Informacao info) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		info.setInclusao(dataF);
		return infoRepository.save(info);
	}
	@GetMapping("/info/{user}")
	public ResponseEntity<List<Informacao>> listarNumerosInfo(@PathVariable String user){
		List<Informacao> info = infoRepository.findByResponsavel(user);
		if (!info.isEmpty()) {
			return new ResponseEntity<>(info,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/oficio")
	@ResponseStatus(HttpStatus.CREATED)
	public Oficio criarNumOficio(@RequestBody Oficio oficio) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		oficio.setInclusao(dataF);
		return oficioRepository.save(oficio);
	}
	@GetMapping("/oficio/{user}")
	public ResponseEntity<List<Oficio>> listarNumerosOficio(@PathVariable String user){
		List<Oficio> oficio = oficioRepository.findByResponsavel(user);
		if (!oficio.isEmpty()) {
			return new ResponseEntity<>(oficio,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/programa")
	@ResponseStatus(HttpStatus.CREATED)
	public Programa criarNumPrograma(@RequestBody Programa programa) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		programa.setInclusao(dataF);
		return programaRepository.save(programa);
	}
	@GetMapping("/programa/{user}")
	public ResponseEntity<List<Programa>> listarNumerosPrograma(@PathVariable String user){
		List<Programa> programa = programaRepository.findByResponsavel(user);
		if (!programa.isEmpty()) {
			return new ResponseEntity<>(programa,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/parecer")
	@ResponseStatus(HttpStatus.CREATED)
	public Parecer criarNumParecer(@RequestBody Parecer parecer) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		parecer.setInclusao(dataF);
		return parecerRepository.save(parecer);
	}
	@GetMapping("/parecer/{user}")
	public ResponseEntity<List<Parecer>> listarNumerosParecer(@PathVariable String user){
		List<Parecer> parecer = parecerRepository.findByResponsavel(user);
		if (!parecer.isEmpty()) {
			return new ResponseEntity<>(parecer,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/ci")
	@ResponseStatus(HttpStatus.CREATED)
	public CI criarNumCI(@RequestBody CI ci) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		ci.setInclusao(dataF);
		return ciRepository.save(ci);
	}
	@GetMapping("/ci/{user}")
	public ResponseEntity<List<CI>> listarNumerosCI(@PathVariable String user){
		List<CI> ci = ciRepository.findByResponsavel(user);
		if (!ci.isEmpty()) {
			return new ResponseEntity<>(ci,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/relatorio-auditoria")
	@ResponseStatus(HttpStatus.CREATED)
	public RelatorioAuditoria criarNumRA(@RequestBody RelatorioAuditoria ra) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		ra.setInclusao(dataF);
		return raRepository.save(ra);
	}
	@GetMapping("/relatorio-auditoria/{user}")
	public ResponseEntity<List<RelatorioAuditoria>> listarNumerosRelatorioAudioria(@PathVariable String user){
		List<RelatorioAuditoria> ra = raRepository.findByResponsavel(user);
		if (!ra.isEmpty()) {
			return new ResponseEntity<>(ra,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/os")
	@ResponseStatus(HttpStatus.CREATED)
	public OS criarNumOS(@RequestBody OS os) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		os.setInclusao(dataF);
		return osRepository.save(os);
	}
	@GetMapping("/os/{user}")
	public ResponseEntity<List<OS>> listarNumerosOS(@PathVariable String user){
		List<OS> os = osRepository.findByResponsavel(user);
		if (!os.isEmpty()) {
			return new ResponseEntity<>(os,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/ajuda")
	@ResponseStatus(HttpStatus.CREATED)
	public Ajuda criarNumAjuda(@RequestBody Ajuda ajuda) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		ajuda.setInclusao(dataF);
		return ajudaRepository.save(ajuda);
	}
	@GetMapping("/ajuda/{user}")
	public ResponseEntity<List<Ajuda>> listarNumerosAjuda(@PathVariable String user){
		List<Ajuda> ajuda = ajudaRepository.findByResponsavel(user);
		if (!ajuda.isEmpty()) {
			return new ResponseEntity<>(ajuda,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/ca")
	@ResponseStatus(HttpStatus.CREATED)
	public CA criarNumCA(@RequestBody CA ca) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		ca.setInclusao(dataF);
		return caRepository.save(ca);
	}
	@GetMapping("/ca/{user}")
	public ResponseEntity<List<CA>> listarNumerosCA(@PathVariable String user){
		List<CA> ca = caRepository.findByResponsavel(user);
		if (!ca.isEmpty()) {
			return new ResponseEntity<>(ca,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/em")
	@ResponseStatus(HttpStatus.CREATED)
	public EM criarNumEM(@RequestBody EM em) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		em.setInclusao(dataF);
		return emRepository.save(em);
	}
	@GetMapping("/em/{user}")
	public ResponseEntity<List<EM>> listarNumerosEM(@PathVariable String user){
		List<EM> em = emRepository.findByResponsavel(user);
		if (!em.isEmpty()) {
			return new ResponseEntity<>(em,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/in")
	@ResponseStatus(HttpStatus.CREATED)
	public InstrucaoNormativa criarNumIN(@RequestBody InstrucaoNormativa in) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		in.setInclusao(dataF);
		return inRepository.save(in);
	}
	@GetMapping("/in/{user}")
	public ResponseEntity<List<InstrucaoNormativa>> listarNumerosIN(@PathVariable String user){
		List<InstrucaoNormativa> in = inRepository.findByResponsavel(user);
		if (!in.isEmpty()) {
			return new ResponseEntity<>(in,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/oc")
	@ResponseStatus(HttpStatus.CREATED)
	public OficioCircular criarNumOC(@RequestBody OficioCircular oc) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		oc.setInclusao(dataF);
		return ocRepository.save(oc);
	}
	@GetMapping("/oc/{user}")
	public ResponseEntity<List<OficioCircular>> listarNumerosOC(@PathVariable String user){
		List<OficioCircular> oc = ocRepository.findByResponsavel(user);
		if (!oc.isEmpty()) {
			return new ResponseEntity<>(oc,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/ot")
	@ResponseStatus(HttpStatus.CREATED)
	public OT criarNumOT(@RequestBody OT ot) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		ot.setInclusao(dataF);
		return otRepository.save(ot);
	}
	@GetMapping("/ot/{user}")
	public ResponseEntity<List<OT>> listarNumerosOT(@PathVariable String user){
		List<OT> ot = otRepository.findByResponsavel(user);
		if (!ot.isEmpty()) {
			return new ResponseEntity<>(ot,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/parecer-rci")
	@ResponseStatus(HttpStatus.CREATED)
	public ParecerRCI criarNumParecerRCI(@RequestBody ParecerRCI rci) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		rci.setInclusao(dataF);
		return parecerRCIRepository.save(rci);
	}
	@GetMapping("/parecer-rci/{user}")
	public ResponseEntity<List<ParecerRCI>> listarNumerosRCI(@PathVariable String user){
		List<ParecerRCI> rci = parecerRCIRepository.findByResponsavel(user);
		if (!rci.isEmpty()) {
			return new ResponseEntity<>(rci,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/portaria")
	@ResponseStatus(HttpStatus.CREATED)
	public Portaria criarNumPortaria(@RequestBody Portaria portaria) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		portaria.setInclusao(dataF);
		return portariaRepository.save(portaria);
	}
	@GetMapping("/portaria/{user}")
	public ResponseEntity<List<Portaria>> listarNumerosPortaria(@PathVariable String user){
		List<Portaria> portaria = portariaRepository.findByResponsavel(user);
		if (!portaria.isEmpty()) {
			return new ResponseEntity<>(portaria,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/portaria-conjunta")
	@ResponseStatus(HttpStatus.CREATED)
	public PortariaConjunta criarNumPC(@RequestBody PortariaConjunta pc) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		pc.setInclusao(dataF);
		return portariaConjuntaRepository.save(pc);
	}
	@GetMapping("/portaria-conjunta/{user}")
	public ResponseEntity<List<PortariaConjunta>> listarNumerosPC(@PathVariable String user){
		List<PortariaConjunta> pc = portariaConjuntaRepository.findByResponsavel(user);
		if (!pc.isEmpty()) {
			return new ResponseEntity<>(pc,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/rca")
	@ResponseStatus(HttpStatus.CREATED)
	public RCA criarNumParecerRCA(@RequestBody RCA rca) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		rca.setInclusao(dataF);
		return rcaRepository.save(rca);
	}
	@GetMapping("/rca/{user}")
	public ResponseEntity<List<RCA>> listarNumerosRCA(@PathVariable String user){
		List<RCA> rca = rcaRepository.findByResponsavel(user);
		if (!rca.isEmpty()) {
			return new ResponseEntity<>(rca,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/relatorio-inspecao")
	@ResponseStatus(HttpStatus.CREATED)
	public RelatorioInspecao criarNumParecerRI(@RequestBody RelatorioInspecao ri) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		ri.setInclusao(dataF);
		return rinspecaoRepository.save(ri);
	}
	@GetMapping("/relatorio-inspecao/{user}")
	public ResponseEntity<List<RelatorioInspecao>> listarNumerosRI(@PathVariable String user){
		List<RelatorioInspecao> ri = rinspecaoRepository.findByResponsavel(user);
		if (!ri.isEmpty()) {
			return new ResponseEntity<>(ri,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/relatorio-investigacao")
	@ResponseStatus(HttpStatus.CREATED)
	public RelatorioInvestigacao criarNumParecerRInvestiga(@RequestBody RelatorioInvestigacao rinvestiga) {
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataF = dataAtual.format(dataFormatada);
		rinvestiga.setInclusao(dataF);
		return rinvestigacaoRepository.save(rinvestiga);
	}
	@GetMapping("/relatorio-investigacao/{user}")
	public ResponseEntity<List<RelatorioInvestigacao>> listarNumerosRInvestiga(@PathVariable String user){
		List<RelatorioInvestigacao> rinvestiga = rinvestigacaoRepository.findByResponsavel(user);
		if (!rinvestiga.isEmpty()) {
			return new ResponseEntity<>(rinvestiga,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
}
