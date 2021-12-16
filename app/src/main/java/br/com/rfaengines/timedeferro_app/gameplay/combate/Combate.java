package br.com.rfaengines.timedeferro_app.gameplay.combate;

public class Combate {

    private boolean habilitarHabilidades;
    private boolean habilitarEspecialHeroi;
    private boolean habilitarEspecialAntagonista;

    private boolean personagemFezEspecial;

    private boolean fimDoCombate;

    private String combateLog;

    private int turno;

    public Combate(){
    }

    public void donoDoTurno(){
        DonoDoTurno.definir();
    }

    public void acaoDoTurno(){
        AcaoDoTurno.definirAcao();
        Especial.habilitarEspecial();
    }

    public void acaoDoComputador(){
        AcaoDoTurno.personagemComputadorAtaca();
    }

    public void confrontoHabilidade(){
        ConfrontoHabilidade.confrontar();
    }

    public void resolucaoHabilidade(){
        ResolucaoHabilidade.resolver();
    }

    public void resolucaoEspecial(){
        ResolucaoEspecial.resolver();
    }

    public void fimDoTurno(){
        FimDoTurno.verificarVencedor();
    }

    public void iniciarStatusCombate(){
        habilitarHabilidades = false;
        habilitarEspecialHeroi = false;
        habilitarEspecialAntagonista = false;
        personagemFezEspecial = false;
        fimDoCombate = false;
        combateLog = "";
        turno = 1;
    }

    public void avancarProximoTurno(){
        this.turno++;
    }

    public int getTurno(){
        return turno;
    }

    public String getCombateLog() {
        return combateLog;
    }

    public boolean isFimDoCombate() {
        return fimDoCombate;
    }

    public void setFimDoCombate(boolean fimDoCombate) {
        this.fimDoCombate = fimDoCombate;
    }

    public void setCombateLog(String combateLog) {
        this.combateLog = combateLog;
    }

    public boolean isHabilitarEspecialHeroi() {
        return habilitarEspecialHeroi;
    }

    public void setHabilitarEspecialHeroi(boolean habilitarEspecialHeroi) {
        this.habilitarEspecialHeroi = habilitarEspecialHeroi;
    }

    public boolean isHabilitarEspecialAntagonista() {
        return habilitarEspecialAntagonista;
    }

    public void setHabilitarEspecialAntagonista(boolean habilitarEspecialAntagonista) {
        this.habilitarEspecialAntagonista = habilitarEspecialAntagonista;
    }

    public boolean isPersonagemFezEspecial() {
        return personagemFezEspecial;
    }

    public void setPersonagemFezEspecial(boolean personagemFezEspecial) {
        this.personagemFezEspecial = personagemFezEspecial;
    }

    public boolean isHabilitarHabilidades() {
        return habilitarHabilidades;
    }

    public void setHabilitarHabilidades(boolean habilitarHabilidades) {
        this.habilitarHabilidades = habilitarHabilidades;
    }
}
